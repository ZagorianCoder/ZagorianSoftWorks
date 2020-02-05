package dataload;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import datamodel.MeasurementRecord;

public class Loader implements ILoader<MeasurementRecord> {
	
	private int uploadedLines = 0;
	
	@Override
	public int load(String fileName, String delimeter, boolean hasHeaderLine, int numFields, ArrayList<MeasurementRecord> objCollection) {
		
		File file = new File(fileName);
		
		try {
			
			Scanner scan = new Scanner(file);
			
			if(hasHeaderLine == true) {
	
				scan.nextLine();
			}
			
			while(scan.hasNextLine()) {
				
				MeasurementRecord measurementRecord = new MeasurementRecord(scan.nextLine(), delimeter, numFields);
				
				if (measurementRecord.initialize_fields() == true) {
					
					uploadedLines += 1;
					objCollection.add(measurementRecord);
					
				}
				
			}
			return uploadedLines;
			
		} catch (FileNotFoundException e) {
			
			System.out.println("Error:FilenotFound! Please provide the correct path of the file you want to load or type exit to main menu");
			System.out.print("File Path: ");
			Scanner input = new Scanner(System.in);
			String answer = input.nextLine();
			
			if(answer.equals("exit")) {
				
				return -1;
				
			}else {
			
				return load(answer, delimeter, hasHeaderLine, numFields, objCollection);
				
			}
			
		}
	
	}
	
}