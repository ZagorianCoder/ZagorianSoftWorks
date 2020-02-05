package timeaggregation;

import java.util.ArrayList;
import java.util.HashMap;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

import datamodel.IResult;
import datamodel.MeasurementRecord;
import datamodel.Result;

public class Aggregator implements IAggregator{
	
	private String timeUnitType;
	private String description;
	private String aggFunction;
	private Result result;
	
	
	
	public Aggregator(String timeUnitType, String description, String aggFunction) {
		
		this.timeUnitType = timeUnitType;
		this.description = description;
		this.aggFunction = aggFunction;
		result = new Result(timeUnitType);
		result.setDescription(description);
		result.setAggFunction(aggFunction);
		
	}

	
	@Override
	public IResult aggregateByTimeUnit(ArrayList<MeasurementRecord> inputMeasurements, String aggFunction, String description) {
		
		
		add_by_timeUnit(result, inputMeasurements);
		
		if ( aggFunction.equals("average")) {
			
			for (String key : result.getDetailedResults().keySet()) {
				
				calculate_average_and_add(key, result.getDetailedResults().get(key));
				
			}
			return result;
			
		} else {
			
			for (String key : result.getDetailedResults().keySet()) {
				
				calculate_sum_and_add(key,  result.getDetailedResults().get(key));
				
			}
			return result;
			
		}
		
		
	}

	private void add_by_timeUnit(Result result, ArrayList<MeasurementRecord> inputMeasurements){
		
		for (int i = 0; i < inputMeasurements.size(); i++) {
			result.add(timeUnitType, inputMeasurements.get(i));
		}
		
	}
	
	private void calculate_average_and_add(String key, ArrayList<MeasurementRecord> records){
		
		DescriptiveStatistics kitchen_stats = new DescriptiveStatistics();
		DescriptiveStatistics laundry_stats = new DescriptiveStatistics();
		DescriptiveStatistics ac_stats = new DescriptiveStatistics();
		
		for (int i = 0; i < records.size(); i++) {
			
			MeasurementRecord record = records.get(i);
			kitchen_stats.addValue(record.getSub_metering_1());
			laundry_stats.addValue(record.getSub_metering_2());
			ac_stats.addValue(record.getSub_metering_3());
			
		}
		
		result.getAggregateMeterKitchen().put(key, kitchen_stats.getMean());
		result.getAggregateMeterLaundry().put(key, laundry_stats.getMean());
		result.getAggregateMeterAC().put(key, ac_stats.getMean());
		
	}
	
	private void calculate_sum_and_add(String key, ArrayList<MeasurementRecord> records){
		
		DescriptiveStatistics kitchen_stats = new DescriptiveStatistics();
		DescriptiveStatistics laundry_stats = new DescriptiveStatistics();
		DescriptiveStatistics ac_stats = new DescriptiveStatistics();
		
		for (int i = 0; i < records.size(); i++) {
			
			MeasurementRecord record = records.get(i);
			kitchen_stats.addValue(record.getSub_metering_1());
			laundry_stats.addValue(record.getSub_metering_2());
			ac_stats.addValue(record.getSub_metering_3());
			
		}
		
		result.getAggregateMeterKitchen().put(key, kitchen_stats.getSum());
		result.getAggregateMeterLaundry().put(key, laundry_stats.getSum());
		result.getAggregateMeterAC().put(key, ac_stats.getSum());
		
	}
	
	@Override
	public String getTimeUnitType() {
		return timeUnitType;
	}

}

