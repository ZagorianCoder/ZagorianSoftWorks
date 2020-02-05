package client;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;


import datamodel.IResult;
import datamodel.MeasurementRecord;
import mainengine.IMainEngine;
import mainengine.MainEngine;
import mainengine.MainEngineFactory;

public class EnergyConsumptionStatistics {
	
	private static ArrayList<MeasurementRecord> file = new ArrayList<MeasurementRecord>();
	private static IResult mainResult;
	private static int state =1;
	
	private static void printMenu() {
		if (state == 1) {
			
			
			System.out.println("1.Load File");
			System.out.println("2.Exit");
			
		}else if(state == 2) {
			
			System.out.println("1.Load File");
			System.out.println("2.Produce Statistics");
			System.out.println("3.Display ReportsHistory");
			System.out.println("4.Exit");
			
		}else if(state == 3) {
			
			System.out.println("1.Load File");
			System.out.println("2.Produce Statistics");
			System.out.println("3.Produce Report");
			System.out.println("3.Display Reports History");
			System.out.println("5.Exit");
			
		}
		
	}

	public static void main(String[] args) {
		
		System.out.println("		Welcome to Energy Consumption Statistics	    ");
		MainEngineFactory mf = new MainEngineFactory();
		MainEngine mainEngine = (MainEngine) mf.createMainEngine("MainEngine");
		select_factionality(mainEngine);
		
		
	}
	
	private static void select_factionality(IMainEngine mainEngine) {
		Scanner scanner_of_select = new Scanner(System.in);
		String choice = null;
		while(true) {
			
			System.out.println("Available fuctionalities:");
			printMenu();
			System.out.print("Choose by typing the name of a fuctionality: ");
			choice = scanner_of_select.nextLine();
			//System.out.println();
			while(validate_choice(choice) == false) {
				System.out.print("Ivalid choice! Try again.\nchoice: ");
				choice = scanner_of_select.nextLine();
			}
			//boolean correct = false;
			if( choice.toLowerCase().equals("load file") ) {
				
				if(loadFile(mainEngine) > 1) {
					
					state = 2;
					
				
				}else {
					
					System.out.println("Something went wrong ! File did not load!");
					
				}
			}else if( choice.toLowerCase().equals("exit") ){
				exit();
			}else if( choice.toLowerCase().equals("produce statistics") ) {
				
				mainResult = produceStatistics(mainEngine);
				
				if (mainResult != null) {
					
					state = 3;
					
				}
				
			}else if( choice.toLowerCase().equals("produce report") ) {
				produceReport(mainEngine);
			}else {
				((MainEngine) mainEngine).displayReportsHistory();
			}
			
		}
		
	}
		
	private static boolean validate_choice(String choice) {
		
		if(choice.toLowerCase().equals("load file")) {
			
			return true;
			
		}else if(choice.toLowerCase().equals("exit")) {
			
			return true;
			
		}else if(choice.toLowerCase().equals("produce statistics") && state >= 2) {
			
			return true;
			
		}else if(choice.toLowerCase().equals("produce report") && state == 3) {
			
			return true;
			
		}else if(choice.toLowerCase().equals("display reports history") && state >= 2) {
			
			return true;
		}
		return false;
	
		
	}
	
	private static int loadFile(IMainEngine mainEngine) {
		
		boolean headerLine = false;
		Scanner input = new Scanner(System.in);
		System.out.println("Please provide the path of the file you want to upload or type exit to return to main menu: ");
		String path = input.nextLine();
		
		if (path.toLowerCase().equals("exit")) {
			return -1;
		}
		
		File input_file = new File(path);
		
		if (input_file.exists() == false) {
			
			System.out.println("Invalid path! The file doesn't exist");
			return loadFile(mainEngine);
			
		}
		
		System.out.print("Please provide the delimiter who separates the columuns in your file: ");
		String delimiter = input.nextLine();
		System.out.print("Does your file contains Header Line? Type yes or no: ");
		
		if(input.nextLine().toLowerCase().equals("yes")) {
			headerLine = true;
		}
		
		return mainEngine.loadData(path, delimiter, headerLine, 9, file);
	}
	
	private static IResult produceStatistics(IMainEngine mainEngine) {
		String aggregatorType;
		String aggFunction;
		String description;
		System.out.println("Availabe time periods to aggregate your measurements:");
		System.out.println("1.Season");
		System.out.println("2.Month");
		System.out.println("3.DayofWeek");
		System.out.println("4.TimeofDay");
		System.out.println("choose by typing the name of the time period you want.");
		System.out.println("To return to main menu type exit.");
		Scanner input = new Scanner(System.in);
		
		do {
			
			System.out.println("TimePeriod: ");
			aggregatorType = input.nextLine();
			if(aggregatorType.toLowerCase().equals("exit")) {
				
				return null;
			}
		}while(validateAggregatorType(aggregatorType) == false);
		
		System.out.println("choose a function sum or average or type exit to return to main menu");
		
		do {
			
			System.out.print("Function: ");
			aggFunction = input.nextLine().toLowerCase();
			if(aggFunction.equals("exit")) {
				input.close();
				return null;
			}
			 
		}while(aggFunction.equals("sum")== false && aggFunction.equals("average") == false);
		
		System.out.println("Provide a description about the produced statistics");
		System.out.print("Description: ");
		description = input.nextLine();
		
		return mainEngine.aggregateByTimeUnit(file, aggregatorType, aggFunction, description);
	}
	
	private static boolean validateAggregatorType(String aggregatorType) {
		
		if(aggregatorType.toLowerCase().equals("season")) {
			
			return true;
			
		}else if(aggregatorType.toLowerCase().equals("month")) {
			
			return true;
			
		}else if(aggregatorType.toLowerCase().equals("dayofweek")) {
			
			return true;
			
		}else if(aggregatorType.toLowerCase().equals("timeofday")) {
			
			return true;
			
		}
		return false;
	}
	
	private static int produceReport(IMainEngine mainEngine) {
		Scanner input = new Scanner(System.in);
		System.out.println("provide the path of the folder you want to create the report or type exit to return to main menu");
		String folderPath = input.nextLine();
		
		if(folderPath.toLowerCase().equals("exit")){
			return 0;
		}

		File input_folder = new File(folderPath);
		
		if( input_folder.isDirectory() == false){
			System.out.println("Folder dont exist!");
			return produceReport(mainEngine);
		}
		
		System.out.print("provide a name for the file: ");
		String name = input.nextLine();
		System.out.print("provide the type of file you want to create such as md , html or txt without a fullstop( . ): ");
		String reportType = input.nextLine().toLowerCase();
		
		while(isValidFileType(reportType) == false) {
			reportType = input.nextLine().toLowerCase();
		}
		
		String filename = folderPath + "\\" + name + "." + reportType;
		
		return mainEngine.reportResultInFile(mainResult, reportType, filename);
	}
	
	private static boolean isValidFileType(String reportType){
		
		if(reportType.equals("md") || reportType.equals("html") || reportType.equals("txt")) {
			return true;
		}
		
		return false;
	}
	
	private static void exit() {
		System.out.println("Program finished!");
		System.exit(0);
	}
	
}
