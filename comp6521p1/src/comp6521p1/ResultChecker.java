package comp6521p1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ResultChecker {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Please input the number of phase");
		
		String phaseNbr = scan.next();
		
		if(Integer.parseInt(phaseNbr) == 1) {
			System.out.println("Please input the file number");
			String fileString = scan.next();
			int fileNbr = Integer.parseInt(fileString);
			
			File[] files = new File[fileNbr];
			for (int i = 0; i < files.length; i++) {
				File file = new File("output_phase_1_file_" + i + ".txt");
				files[i] = file;
			}
			
			int count = 0;
			for (int i = 0; i < files.length; i ++) {
				if(files[i] != null && files[i].exists()) {
					try {
						Scanner read = new Scanner(files[i]);
						while(read.hasNext()) {
							read.next();
							count ++;
						}
						read.close();
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
				}
			}
			System.out.println("total Integer: " + count);
		}
		
		if(Integer.parseInt(phaseNbr) == 2) {
			System.out.println("Please input the stage of files");		
			int stageNbr = Integer.parseInt(scan.next());		
			System.out.println("Please input the number of files");		
			int fileNbr = Integer.parseInt(scan.next());
			
			File[] files = new File[stageNbr * fileNbr];
			for (int j = 0; j < stageNbr + 1; j++) {
				for (int i = 0; i < files.length; i++) {
					File file = new File("output_phase_2_stage_" + stageNbr + "_file_" + fileNbr + ".txt");
					files[i+j] = file;
				}
			}
			
			int count = 0;
			for (int j = 0; j < stageNbr + 1; j ++) {
				for(int i=0; i< files.length; i++) {
					if(files[i+j] != null && files[i+j].exists()) {
						try {
							Scanner read = new Scanner(files[i]);
							while(read.hasNext()) {
								read.next();
								count ++;
							}
							read.close();
						} catch (FileNotFoundException e) {
							e.printStackTrace();
						}
					}
				}
			}
			System.out.println("total Integer: " + count);
		}
		
		scan.close();
	}
}
