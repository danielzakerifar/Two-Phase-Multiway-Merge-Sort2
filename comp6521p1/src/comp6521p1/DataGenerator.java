package comp6521p1;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

/**
 * This class is used to generate large data files.
 *
 */
public class DataGenerator {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Please input the number of tuples");
		System.out.println("262144 > 1MB 2621440 > 10MB");
		String tupleNbr = scan.next();	
		
		System.out.println("Please input the main memory limitation");	
		String memorySize = scan.next();
		scan.close();
		
		int countdown = Integer.parseInt(tupleNbr);
		Random random = new Random();
		try {
			File writename = new File(".\\dataInput.txt");
			writename.createNewFile();
			BufferedWriter out = new BufferedWriter(new FileWriter(writename));
			out.write(tupleNbr + " " + memorySize + "\r\n");
			System.out.println("Writing ....");
			
			while(countdown > 0){
				String line = "";
				for(int i = 0; i < 27; i++) {
					if(countdown <= 0) {
						break;
					}
					countdown--;
					int number = random.nextInt(100000) * 10 + random.nextInt(10);
					line += String.valueOf(number) + " ";
				}
				out.write(line + "\r\n");
			}
			out.flush();
			out.close();
			System.out.print("Done!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
