package mainengine;

import java.time.LocalTime;
import java.util.ArrayList;

import dataload.Loader;
import datamodel.IResult;
import datamodel.MeasurementRecord;
import reporting.Reporter;
import timeaggregation.Aggregator;

public class MainEngine implements IMainEngine {
	
	 private ArrayList<String> reports_storage = new ArrayList<String>();

	@Override
	public int loadData(String fileName, String delimeter, Boolean hasHeaderLine, int numFields, ArrayList<MeasurementRecord> objCollection) {
		Loader loader = new Loader();
		
		int loaded_lines = loader.load(fileName, delimeter, hasHeaderLine, numFields, objCollection);
		
		if (loaded_lines > 1) {
			
			updateReportsHistory(LocalTime.now() + " File loaded from " + fileName);
			
		}
		return loaded_lines;
	}

	@Override
	public IResult aggregateByTimeUnit(ArrayList<MeasurementRecord> inputMeasurements, String aggregatorType,String aggFunction, String description) {
		
		Aggregator aggregator = new Aggregator(aggregatorType, description, aggFunction);
		IResult result = aggregator.aggregateByTimeUnit(inputMeasurements, aggFunction, description);
		
		if(result != null) {
			
			updateReportsHistory(LocalTime.now() + " Statistics created by " + aggregatorType + " with the fuction of " + aggFunction);
			
		}
		return result;
	}

	@Override
	public int reportResultInFile(IResult result, String reportType, String filename) {
		
		Reporter reporter = new Reporter();
		int report_created = reporter.reportResultInFile(result, filename);
		
		if(report_created == 0) {
			
			updateReportsHistory(LocalTime.now() + "  Statistics report created to " + filename );
			
		}
		return report_created ;
	}
	
	private void  updateReportsHistory(String report) {
		
		reports_storage.add(report);
		
	}
	
	public void displayReportsHistory() {
		
		for(int i=0; i < reports_storage.size(); i++) {
			
			System.out.println(reports_storage.get(i));;
			
		}
	}

}
