package datamodel;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.time.LocalTime; 

public class MeasurementRecord{

	private String record;
	private String[] measurement_line;
	private String delimeter;
	private String date;
	private String time;
	private double global_active_power;
	private double global_reactive_power;
	private double voltage;
	private double global_intensity;
	private double sub_metering_1;
	private double sub_metering_2;
	private double sub_metering_3;
	private int numFields;

	public MeasurementRecord(String record, String delimeter,  int numFields){
		
		this.record = record;
		this.delimeter = delimeter;
		this.numFields = numFields;
		
	}
	
	private boolean MakeMatrix() {
		
		if (record.isEmpty() == false) {
			
			if (delimeter.isBlank()) {

				StringTokenizer st = new StringTokenizer(record);
				measurement_line = new String[st.countTokens()];
				int i = 0;
			
				while (st.hasMoreTokens()) {
					measurement_line[i] = st.nextToken();
					i++;
				}
				
			}else{

				measurement_line = record.split(delimeter);
				
				if(measurement_line.length !=  numFields) {
					return false;
				}
			
			}		
			return true;	
		}
		return false;
	}

	public boolean initialize_fields(){
		
		if (MakeMatrix() == true) {
			
			boolean valid_date_and_time = validate_date() && validate_time();
			
			if (!valid_date_and_time) {
				
				System.out.println("date:"+measurement_line[0]+" time: "+measurement_line[1]);
				System.out.println("date = "+ validate_date());
				System.out.println("time = "+ validate_time());
			
			}
			
			boolean valid_energy_voltage_intesity = validate_global_active_power() && validate_global_reactive_power() && validate_voltage() && validate_global_intensity();
			boolean valid_sub_meterings = validate_sub_metering_1() && validate_sub_metering_2() && validate_sub_metering_3();
			return valid_date_and_time && valid_energy_voltage_intesity && valid_sub_meterings;
			
		}
		return false;
	}

	private boolean validate_date() {
		
		String input_date = measurement_line[0];
		boolean isValidMatch1 = input_date.matches("[0-9][0-9]/[0-1][0-9]/[0-9][0-9][0-9][0-9]");
		boolean isValidMatch2 = input_date.matches("[1-9]/[1-9]/[0-9][0-9][0-9][0-9]");
		boolean isValidMatch3 = input_date.matches("[0-9][0-9]/[1-9]/[0-9][0-9][0-9][0-9]");
		boolean isValidMatch4 = input_date.matches("[0-9]/[0-1][0-9]/[0-9][0-9][0-9][0-9]");
		
		if (isValidMatch1 == true || isValidMatch2 == true || isValidMatch3 == true || isValidMatch4 == true){
            
			String [] str_date = input_date.split("/");
			int day = Integer.parseInt(str_date[0]);
			int month = Integer.parseInt(str_date[1]);
			int year = Integer.parseInt(str_date[2]);
            LocalDateTime localdate = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy");
			int localyear = Integer.parseInt(localdate.format(formatter));
			
            if (day <=31 && month <=12 && year <= localyear){
				
            	date = measurement_line[0]; 
                return true;
                
            }else{
            	
            	System.out.println("Invalid Date! Please provide date in this format dd/mm/yyyy");
            	System.out.println("Date: ");
            	Scanner input = new Scanner(System.in);
            	measurement_line[0] = input.nextLine();
            	input.close();
            	validate_date();
            	
            }
		}
		
		return false;
	}
	
	private boolean validate_time() {
		
		String input_time = measurement_line[1];
		
		try {
        
			LocalTime.parse(input_time);
			time = input_time;
			return true;
			
        } catch (Exception e) {
			
        	System.out.println("Invalid Time: " + input_time);
        	
        }
		return false;
	}
	
	private boolean validate_global_active_power() {
		try {
			
			global_active_power = Double.parseDouble(measurement_line[2]);
			return true;
			
		} catch (Exception e) {
			
			System.out.println("Invalid global active power! Please provide a measuremnt of type double for global active power");
			System.out.println("global active power: ");
			Scanner input = new Scanner(System.in);
			measurement_line[2] = input.nextLine();
			input.close();
			validate_global_active_power();
			
		}
		return false;
	}
	
	private boolean validate_global_reactive_power() {
		try {
			
			global_reactive_power = Double.parseDouble(measurement_line[3]);
			return true;
			
		} catch (Exception e) {
			
			System.out.println("Invalid global reactive power! Please provide a measuremnt of type double for global reactive power");
			System.out.println("global reactive power: ");
			Scanner input = new Scanner(System.in);
			measurement_line[3] = input.nextLine();
			input.close();
			validate_global_reactive_power();
			
		}
		return false;
	}
	
	private boolean validate_voltage() {
		
		try {
		
			voltage = Double.parseDouble(measurement_line[4]);
			return true;
			
		} catch (Exception e) {
			
			System.out.println("Invalid voltage! Please provide a measuremnt of type double for voltage");
			System.out.println("voltage: ");
			Scanner input = new Scanner(System.in);
			measurement_line[4] = input.nextLine();
			input.close();
			validate_voltage();
			
		}
		return false;
	}
	
	private boolean validate_global_intensity() {
		try {
			
			global_intensity = Double.parseDouble(measurement_line[5]);
			return true;
			
		} catch (Exception e) {
			
			System.out.println("Invalid global_intensity! Please provide a measuremnt of type double for global_intensity");
			System.out.println("global_intensity: ");
			Scanner input = new Scanner(System.in);
			measurement_line[5] = input.nextLine();
			input.close();
			validate_global_intensity();
			
		}
		return false;
	}
	
	private boolean validate_sub_metering_1() {
		try {
			
			sub_metering_1 = Double.parseDouble(measurement_line[6]);
			return true;
			
		} catch (Exception e) {
			
			System.out.println("Invalid sub_metering_1! Please provide a measuremnt of type double for sub_metering_1");
			System.out.println("sub_metering_1: ");
			Scanner input = new Scanner(System.in);
			measurement_line[6] = input.nextLine();
			input.close();
			validate_sub_metering_1();
			
		}
		return false;
	}
	
	private boolean validate_sub_metering_2() {
		try {
			
			sub_metering_2 = Double.parseDouble(measurement_line[7]);
			return true;
			
		} catch (Exception e) {
			
			System.out.println("Invalid sub_metering_2! Please provide a measuremnt of type double for sub_metering_2");
			System.out.println("sub_metering_2: ");
			Scanner input = new Scanner(System.in);
			measurement_line[7] = input.nextLine();
			input.close();
			validate_sub_metering_2();
			
		}
		return false;
	}
	
	private boolean validate_sub_metering_3() {
		try {
			
			sub_metering_3 = Double.parseDouble(measurement_line[8]);
			return true;
			
		} catch (Exception e) {
			
			System.out.println("Invalid sub_metering_3! Please provide a measuremnt of type double for sub_metering_3");
			System.out.println("sub_metering_3: ");
			Scanner input = new Scanner(System.in);
			measurement_line[8] = input.nextLine();
			input.close();
			validate_sub_metering_3();
			
		}
		return false;
	}
	
	public String getRecord() {
		
		return record;
		
	}

	public String getTime() {
		
		return time;
		
	}



	public String[] getMeasurement_line() {
		
		return measurement_line;
		
	}



	public String getDate() {
		
		return date;
		
	}



	public double getGlobal_active_power() {
		
		return global_active_power;
		
	}



	public double getGlobal_reactive_power() {
		
		return global_reactive_power;
		
	}



	public double getVoltage() {
		
		return voltage;
		
	}



	public double getGlobal_intensity() {
		
		return global_intensity;
		
	}



	public double getSub_metering_1() {
		
		return sub_metering_1;
		
	}



	public double getSub_metering_2() {
		
		return sub_metering_2;
		
	}



	public double getSub_metering_3() {
		
		return sub_metering_3;
		
	}



	public String getDelimeter() {
		
		return delimeter;
		
	}

}
