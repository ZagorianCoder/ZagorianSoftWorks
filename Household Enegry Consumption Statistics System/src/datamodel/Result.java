package datamodel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Result implements IResult {
	
	private String description;
	private HashMap<String, ArrayList<MeasurementRecord>> detailedResults = new HashMap<String, ArrayList<MeasurementRecord>>() ;
	private HashMap<String, Double> aggregateMeterKitchen = new HashMap<String, Double>();
	private HashMap<String, Double> aggregateMeterLaundry = new HashMap<String, Double>();
	private HashMap<String, Double> aggregateMeterAC = new HashMap<String, Double>();
	private String aggFunction;
	private Date time;
	private Date early_morning_time;
	private Date morning_time;
	private Date afternoon_time;
	private Date evening_time;

	public Result(String timeUnitType){
		
		initializeDetailedResults(timeUnitType);
		
	}

	private void initializeDetailedResults(String timeUnitType){
		
		if (timeUnitType.equals("season")) {
			
			initializebySeason();
			
		} else if(timeUnitType.equals("month")) {
			
			initializebyMonth();
			
		} else if (timeUnitType.equals("dayofweek")){
			
			initializebyDayofWeek();
			
		}else{
			
			initializebyTimeofDay();
			
		}
		
	}
	
	private void initializebySeason(){
		
		detailedResults.put("Autumn", new ArrayList<MeasurementRecord>());
		detailedResults.put("Winter", new ArrayList<MeasurementRecord>());
		detailedResults.put("Spring", new ArrayList<MeasurementRecord>());
		detailedResults.put("Summer", new ArrayList<MeasurementRecord>());
		
	}
	
	private void initializebyMonth() {
		
		for (int i = 1; i <= 12; i++) {
			
			detailedResults.put(getMonth(i),new ArrayList<MeasurementRecord>());
			
		}
		
	}
	
	private void initializebyDayofWeek(){
		for (int i = 1; i <= 7; i++) {

			detailedResults.put(getDay(i),new ArrayList<MeasurementRecord>());

		}
	}

	private void initializebyTimeofDay(){
		
		detailedResults.put("Night", new ArrayList<MeasurementRecord>());
		detailedResults.put("Early Morning", new ArrayList<MeasurementRecord>());
		detailedResults.put("Morning", new ArrayList<MeasurementRecord>());
		detailedResults.put("Afternoon", new ArrayList<MeasurementRecord>());
		detailedResults.put("Evening", new ArrayList<MeasurementRecord>());

	}
	
	private String getMonth(int i) {

		try {
			
			Date date = new SimpleDateFormat("M").parse(""+i);
			String month = new SimpleDateFormat("MMM").format(date);
			System.out.println("month: "+month);
			return month;

		} catch (Exception e) {
			
			System.out.println("date can not be parsed");
			return null;
			
		}

	}

	private String getDay(int i) {
		try {
			
			Date date = new SimpleDateFormat("d").parse(""+i);
			String day = new SimpleDateFormat("EEE").format(date);
			System.out.println("day: "+day);
			return day;

		} catch (Exception e) {
			
			System.out.println("date can not be parsed");
			return null;

		}

	}

	

	@Override
	public int add(String timeUnit, MeasurementRecord record){
		
		if (timeUnit.equals("season")) {

			return add_by_season(record);

		} else if(timeUnit.equals("month")) {
			
			return add_by_month(record);
			
		} else if (timeUnit.equals("dayofweek")){
			
			return add_by_day_of_week(record);
			
		}else{
			
			return add_by_time_of_day(record);
			
		}
		
	}
	
	private int add_by_season(MeasurementRecord record){

		String month = getMonth(record);
		if (month.equals("Sep") || month.equals("Oct") || month.equals("Nov")) {
			
			detailedResults.get("Autumn").add(record);
			return detailedResults.get("Autumn").size();

		} else if(month.equals("Dec") || month.equals("Jan") || month.equals("Feb")){
			
			detailedResults.get("Winter").add(record);
			return detailedResults.get("Winter").size();
			
		}else if(month.equals("Mar") || month.equals("Apr") || month.equals("May")){
			
			detailedResults.get("Spring").add(record);
			return detailedResults.get("Spring").size();
			
		}else{
			
			detailedResults.get("Summer").add(record);
			return detailedResults.get("Summer").size();
			
		}

	}

	private int add_by_month(MeasurementRecord record) {

		String month = getMonth(record);
		detailedResults.get(month).add(record);
		return detailedResults.get(month).size();
			
	}

	private int add_by_day_of_week(MeasurementRecord record) {

		String day = getDay(record);

		if (day  == null) {
			return -1; 
		}
		
		detailedResults.get(day).add(record);
		return detailedResults.get(day).size();
		
	}

	private int add_by_time_of_day(MeasurementRecord record) {
		
		if (initializeTimeFields(record) == 0) {

			return calculate_time_period_of_day(time, record);
			
		}
		return -1;

	}

	private int initializeTimeFields(MeasurementRecord record){

		try {
			
			time = new SimpleDateFormat("HH:mm:ss").parse(record.getTime());
			early_morning_time = new SimpleDateFormat("HH:mm:ss").parse("05:00:00");
			morning_time = new SimpleDateFormat("HH:mm:ss").parse("09:00:00");
			afternoon_time = new SimpleDateFormat("HH:mm:ss").parse("13:00:00");
			evening_time = new SimpleDateFormat("HH:mm:ss").parse("17:00:00");
			return 0;

		} catch (Exception e) {
			
			System.out.println("Error: The given time can't be parsed!");
			return -1;

		}

	}

	private int calculate_time_period_of_day(Date time, MeasurementRecord record){
		
		if (time.compareTo(early_morning_time) < 0) {

			detailedResults.get("Night").add(record);
			return detailedResults.get("Night").size();

		} else if (time.compareTo(morning_time) < 0){
			
			detailedResults.get("Early Morning").add(record);
			return detailedResults.get("Early Morning").size();
			
		} else if (time.compareTo(afternoon_time) < 0) {
			
			detailedResults.get("Morning").add(record);
			return detailedResults.get("Morning").size();
			
		}else if (time.compareTo(evening_time) < 0){
			
			detailedResults.get("Afternoon").add(record);
			return detailedResults.get("Afternoon").size();
			
		}else{

			detailedResults.get("Evening").add(record);
			return detailedResults.get("Evening").size();

		}

	}

	private String getDay(MeasurementRecord record) {
		
		try {
			
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(record.getDate());
			String day = new SimpleDateFormat("EEE").format(date);
			System.out.println("day2: "+day);
			return day;

		} catch (Exception e) {
			
			System.out.println("date can not be parsed");
			return null;
			
		}

	}

	private String getMonth(MeasurementRecord record) {

		try {
			
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(record.getDate());
			String month = new SimpleDateFormat("MMM").format(date);
			System.out.println("month2: "+month);
			return month;

		} catch (Exception e) {

			System.out.println("date can not be parsed");
			return null;
			
		}

	}

	@Override
	public String getDescription() {
		
		return description;
		
	}

	@Override
	public HashMap<String, ArrayList<MeasurementRecord>> getDetailedResults() {
		
		return detailedResults;
		
	}

	@Override
	public HashMap<String, Double> getAggregateMeterKitchen() {
		
		return aggregateMeterKitchen;
		
	}

	@Override
	public HashMap<String, Double> getAggregateMeterLaundry() {
		
		return aggregateMeterLaundry;
		
	}

	@Override
	public HashMap<String, Double> getAggregateMeterAC() {
		
		return aggregateMeterAC;
		
	}

	@Override
	public String getAggregateFunction() {
		
		return aggFunction;
		
	}

	
	public void setAggFunction(String aggFunction) {
		
		this.aggFunction = aggFunction;
		
	}

	public void setDescription(String description) {
		
		this.description = description;
		
	}

}
