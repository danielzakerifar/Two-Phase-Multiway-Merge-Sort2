package comp6521p1;

/**
 * Multi-phase multiway merge-sort parameters
 *
 */
public class MPMMS {

	long numOfSubLists;
	long numOfIntInMemory;

	static int SEEK_TIME = 10;
	static int ROTATIONAL_LATENCY = 1;
	static int TRANSFER_TIME_PER_BLOCK = 5;

	public MPMMS(int numOfSubLists, int numOfIntInMemory) {
		this.numOfSubLists = numOfSubLists;
		this.numOfIntInMemory = numOfIntInMemory;
	}

	int calculateNumOfInputBuffers() {
		double leastCost = Double.MAX_VALUE;
		int result = -1;

		// Least number of buffers to merge is 2
		for (int i = 2; i <= numOfSubLists && i < numOfIntInMemory; i++) {
			double cost = calculateCost(i);
			if (cost < leastCost) {
				leastCost = cost;
				result = i;
			}
		}
		return result;
	}

	double calculateCost(int numOfBuffers) {
		int noPhase = (int) Math.ceil(Math.log(numOfSubLists) / Math.log(numOfBuffers));
		return noPhase * (((double) SEEK_TIME + ROTATIONAL_LATENCY) / numOfIntInMemory
				* Math.pow(Math.sqrt(numOfBuffers) + 1, 2) + 2 * TRANSFER_TIME_PER_BLOCK);
	}

	int calculateBufferSize() {
		int maxValid = Math.floorDiv((int) numOfIntInMemory - 1, (int) numOfSubLists);
		int minValid = 1;

		double sqrtW = Math.sqrt(numOfSubLists);
		int result = (int) Math.round(numOfIntInMemory * (sqrtW - 1) / (sqrtW * (numOfSubLists - 1)));

		if (result < minValid) {
			return 1;
		}

		if (result > maxValid) {
			return maxValid;
		}

		return result;
	}

	int calculateOutputBufferSize(int numOfInputBuffers, int inputBufferSize) {
		return (int) numOfIntInMemory - (calculateNumOfInputBuffers() * inputBufferSize);
	}

}
