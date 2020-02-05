package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;


import datamodel.IResult;
import datamodel.MeasurementRecord;
import mainengine.IMainEngine;
import mainengine.MainEngineFactory;


public class MainEngineTest {
	private static IMainEngine mainEngine;
	private static MainEngineFactory factory;
	private static ArrayList<MeasurementRecord> objCollection;
	private static IResult result;
	static private String inputFilename;
	static private String outputFilename;
	static private String delimeter;
	static private Boolean hasHeader;
	static private int numFields;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		factory = new MainEngineFactory();
		mainEngine = factory.createMainEngine("MainEngine");
		objCollection = new ArrayList<MeasurementRecord>();

		inputFilename = "./Resources/TestInput/2007_sample.tsv";
		delimeter = "\t";
		hasHeader = false;
		numFields = 9;
		objCollection = new ArrayList<MeasurementRecord>(); 
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		objCollection = new ArrayList<MeasurementRecord>(); 
		result = null;
	}

	/**
	 * Test method for {@link mainengine.MainEngine#loadData(java.lang.String, java.lang.String, java.lang.Boolean, int, java.util.ArrayList)}.
	 */
	@Test
	public final void testLoadData() {
		
		int numRows = mainEngine.loadData("./Resources/TestInput/hld_with_emptyCells.txt", ";", true, numFields, objCollection);	
		assertEquals(numRows, 4);
	}

	/**
	 * Test method for {@link mainengine.MainEngine#aggregateByTimeUnit(java.util.ArrayList, java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	public final void testAggregateByTimeUnit() {

		int numRows = mainEngine.loadData(inputFilename, delimeter, hasHeader, numFields, objCollection);
		System.out.println("Size to process: " + numRows);
		
		result = mainEngine.aggregateByTimeUnit(objCollection, "dayofweek", "average", "Day of week avg aggregation over 2007 sample");
		
		//result.reportAggregates();
		assertEquals(result.getAggregateMeterKitchen().get("Mon"), 1.0 ,2);
		assertEquals(result.getAggregateMeterKitchen().get("Tue"), 1.9473684210526316 ,2);
		assertEquals(result.getAggregateMeterKitchen().get("Wed"), 0.041666666666666664 ,2);
		assertEquals(result.getAggregateMeterKitchen().get("Thu"), 1.7999999999999998 ,2);
		assertEquals(result.getAggregateMeterKitchen().get("Fri"), 0.30769230769230765 ,2);
		assertEquals(result.getAggregateMeterKitchen().get("Sat"), 0.0 ,2);
		assertEquals(result.getAggregateMeterKitchen().get("Sun"), 0.07142857142857144,2);

		assertEquals(result.getAggregateMeterLaundry().get("Mon"), 0.5625 ,2);
		assertEquals(result.getAggregateMeterLaundry().get("Tue"), 0.42105263157894735 ,2);
		assertEquals(result.getAggregateMeterLaundry().get("Wed"), 2.25 ,2);
		assertEquals(result.getAggregateMeterLaundry().get("Thu"), 0.25 ,2);
		assertEquals(result.getAggregateMeterLaundry().get("Fri"), 0.4615384615384615 ,2);
		assertEquals(result.getAggregateMeterLaundry().get("Sat"), 0.14285714285714288 ,2);
		assertEquals(result.getAggregateMeterLaundry().get("Sun"), 0.8571428571428571,2);


		assertEquals(result.getAggregateMeterAC().get("Mon"), 2.1875 ,2);
		assertEquals(result.getAggregateMeterAC().get("Tue"), 3.7368421052631584 ,2);
		assertEquals(result.getAggregateMeterAC().get("Wed"), 5.125 ,2);
		assertEquals(result.getAggregateMeterAC().get("Thu"), 3.8 ,2);
		assertEquals(result.getAggregateMeterAC().get("Fri"), 6.769230769230769 ,2);
		assertEquals(result.getAggregateMeterAC().get("Sat"), 9.857142857142858 ,2);
		assertEquals(result.getAggregateMeterAC().get("Sun"), 4.857142857142857,2);
		
	}

	/**
	 * Test method for {@link mainengine.MainEngine#reportResultInFile(datamodel.IResult, java.lang.String, java.lang.String)}.
	 */
	@Test
	public final void testReportResultInFile() {
		
		//Average by Season
		
		outputFilename = "./Resources/TestOutput/2007SampleSeasonAggregateAVG_Output.txt";
		int numRows = mainEngine.loadData(inputFilename, delimeter, hasHeader, numFields, objCollection);
		System.out.println("Size to process: " + numRows);
		
		result = mainEngine.aggregateByTimeUnit(objCollection, "season", "average", "By Season avg aggregation over 2007");
		System.out.println("Time units with measurements: " + result.getDetailedResults().size());
		
		int printOutcome = mainEngine.reportResultInFile(result, "txt", outputFilename);
		assertEquals(printOutcome, 0);
		assertEquals(FileUtilities.countLinesOfAFile(outputFilename),24);
		
		// Average by Month
		
		outputFilename = "./Resources/TestOutput/2007SampleMonthlyAggregateAVG_Output.md";
		numRows = mainEngine.loadData(inputFilename, delimeter, hasHeader, numFields, objCollection);
		System.out.println("Size to process: " + numRows);
		
		result = mainEngine.aggregateByTimeUnit(objCollection, "month", "average", "Monthly avg aggregation over 2007");
		System.out.println("Time units with measurements: " + result.getDetailedResults().size());
		
		printOutcome = mainEngine.reportResultInFile(result, "md", outputFilename);
		assertEquals(printOutcome, 0);
		assertEquals(FileUtilities.countLinesOfAFile(outputFilename),48);
		
		// Average by Day of Week
		
		outputFilename = "./Resources/TestOutput/2007SampleDayofWeekAggregateAVG_Output.html";
		numRows = mainEngine.loadData(inputFilename, delimeter, hasHeader, numFields, objCollection);
		System.out.println("Size to process: " + numRows);
		
		result = mainEngine.aggregateByTimeUnit(objCollection, "dayofweek", "average", "By Day of week avg aggregation over 2007");
		System.out.println("Time units with measurements: " + result.getDetailedResults().size());
		
		printOutcome = mainEngine.reportResultInFile(result, "html", outputFilename);
		assertEquals(printOutcome, 0);
		assertEquals(FileUtilities.countLinesOfAFile(outputFilename),21);
		
		// Average by Time of Day
		
		outputFilename = "./Resources/TestOutput/2007SampleTimeofDayAggregateAVG_OutputAVG.html";
		numRows = mainEngine.loadData(inputFilename, delimeter, hasHeader, numFields, objCollection);
		System.out.println("Size to process: " + numRows);
		
		result = mainEngine.aggregateByTimeUnit(objCollection, "timeofday", "average", "By Day of week avg aggregation over 2007");
		System.out.println("Time units with measurements: " + result.getDetailedResults().size());
		
		printOutcome = mainEngine.reportResultInFile(result, "html", outputFilename);
		assertEquals(printOutcome, 0);
		assertEquals(FileUtilities.countLinesOfAFile(outputFilename),21);

		//Summary by Season
		
		outputFilename = "./Resources/TestOutput/2007SampleSeasonAggregateSUM_Output.txt";
		int numRows1 = mainEngine.loadData(inputFilename, delimeter, hasHeader, numFields, objCollection);
		System.out.println("Size to process: " + numRows1);
		
		result = mainEngine.aggregateByTimeUnit(objCollection, "season", "sum", "By Season sum aggregation over 2007");
		System.out.println("Time units with measurements: " + result.getDetailedResults().size());
		
		int printOutcome1 = mainEngine.reportResultInFile(result, "txt", outputFilename);
		assertEquals(printOutcome1, 0);
		assertEquals(FileUtilities.countLinesOfAFile(outputFilename),24);
		
		// Summary by Month
		
		outputFilename = "./Resources/TestOutput/2007SampleMonthlyAggregateSUM_Output.md";
		numRows1 = mainEngine.loadData(inputFilename, delimeter, hasHeader, numFields, objCollection);
		System.out.println("Size to process: " + numRows1);
		
		result = mainEngine.aggregateByTimeUnit(objCollection, "sum", "average", "Monthly sum aggregation over 2007");
		System.out.println("Time units with measurements: " + result.getDetailedResults().size());
		
		printOutcome1 = mainEngine.reportResultInFile(result, "md", outputFilename);
		assertEquals(printOutcome1, 0);
		assertEquals(FileUtilities.countLinesOfAFile(outputFilename),27);
		
		// Summary by Day of Week
		
		outputFilename = "./Resources/TestOutput/2007SampleDayofWeekAggregateSUM_Output.html";
		numRows1 = mainEngine.loadData(inputFilename, delimeter, hasHeader, numFields, objCollection);
		System.out.println("Size to process: " + numRows1);
		
		result = mainEngine.aggregateByTimeUnit(objCollection, "dayofweek", "sum", "By Day of week sum aggregation over 2007");
		System.out.println("Time units with measurements: " + result.getDetailedResults().size());
		
		printOutcome1 = mainEngine.reportResultInFile(result, "html", outputFilename);
		assertEquals(printOutcome1, 0);
		assertEquals(FileUtilities.countLinesOfAFile(outputFilename),21);
		
		// Summary by Time of Day
		
		outputFilename = "./Resources/TestOutput/2007SampleTimeofDayAggregateSUM_Output.html";
		numRows1 = mainEngine.loadData(inputFilename, delimeter, hasHeader, numFields, objCollection);
		System.out.println("Size to process: " + numRows1);
		
		result = mainEngine.aggregateByTimeUnit(objCollection, "timeofday", "sum", "By Day of week sum aggregation over 2007");
		System.out.println("Time units with measurements: " + result.getDetailedResults().size());
		
		printOutcome1 = mainEngine.reportResultInFile(result, "html", outputFilename);
		assertEquals(printOutcome1, 0);
		assertEquals(FileUtilities.countLinesOfAFile(outputFilename),21);

	}

}
