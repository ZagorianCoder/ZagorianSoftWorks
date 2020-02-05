package reporting;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import datamodel.IResult;

public class Reporter implements IResultReporter {

	@Override
	public int reportResultInFile(IResult result, String filename) {
		PrintWriter pw = createFile(filename);
		String type = getFileType(filename);
		if (pw != null) {
			if(type.equals("txt")) {
				
				pw.println(result.getDescription());
				pw.println();
				String line = result.getAggregateFunction()+" consumption (watt-hours) over (a) Kitchen, (b) Laundry, (c) A/C";
				pw.println(line);
				write_results_for_Kitchen_txt(result, pw);
				write_results_for_Laundry_txt(result, pw);
				write_results_for_AC_txt(result, pw);
				pw.close();
				return 0;
				
			}else if(type.equals("html")){
				
				pw.println("<HTML>");
				pw.println("<BODY>");
				pw.println("<HR><B><U><BIG><BR>"+result.getDescription()+"</HR></B></U></BIG></BR>");
				String line ="<BR>"+ result.getAggregateFunction()+" consumption (watt-hours) over (a) Kitchen, (b) Laundry, (c) A/C</BR>";
				pw.println(line);
				write_results_for_Kitchen_html(result, pw);
				write_results_for_Laundry_html(result, pw);
				write_results_for_AC_html(result, pw);
				pw.println("</BODY>");
				pw.println("</HTML>");
				pw.close();
				return 0;
			
			}else {
				
				pw.println("# "+result.getDescription());
				pw.println();
				String line = result.getAggregateFunction()+" consumption (watt-hours) over (a) Kitchen, (b) Laundry, (c) A/C";
				pw.println(line);
				write_results_for_Kitchen(result, pw);
				write_results_for_Laundry(result, pw);
				write_results_for_AC(result, pw);
				pw.close();
				return 0;
				
			}
			
		}
		return -1;
	}
	
	private String getFileType(String filename) {
		
		File file = new File(filename);
		String nameofFile = file.getName();
		String [] filename_splited = nameofFile.split("\\.");
		return filename_splited[filename_splited.length -1];
		
	}
	
	private PrintWriter createFile(String filename) {
		
		File file = new File(filename);
		try {
			
			FileWriter writer = new FileWriter(filename);
			PrintWriter pw = new PrintWriter(writer);
			return pw;
			
		} catch (IOException e) {
			
			System.err.println("Error: The Creation of the file failed");
			System.err.println("Invalid Path: " + filename);
			return null;
			
		}
	}
	
	
	
	private void write_results_for_Kitchen(IResult result, PrintWriter pw) {
		
		pw.println();
		pw.println("## Kitchen");
		pw.println();
		HashMap<String, Double> kitchenResults = result.getAggregateMeterKitchen();
		
		for (String key : kitchenResults.keySet()) {
			
			if(kitchenResults.get(key).toString().equals("NaN") == false ){
				
				String line = String.format("* %-20s %.2f\n", key, kitchenResults.get(key));
				pw.printf(line);

			}
		}
	}
	
	private void write_results_for_Kitchen_txt(IResult result, PrintWriter pw) {

		pw.println();
		pw.println("Kitchen");
		pw.println();
		HashMap<String, Double> kitchenResults = result.getAggregateMeterKitchen();
		
		for (String key : kitchenResults.keySet()) {
		
			if(kitchenResults.get(key).toString().equals("NaN") == false ){
				
				String line = String.format("·%-20s %.2f\n", key, kitchenResults.get(key));
				pw.printf(line);

			}
		}
	}
	
	private void write_results_for_Kitchen_html(IResult result, PrintWriter pw) {

		pw.println("<HR><B><U><BR>Kitchen</HR></B></U></BR>");
		pw.println("<P ALIGN = RIGHT>");
		HashMap<String, Double> kitchenResults = result.getAggregateMeterKitchen();
		pw.println("<UL>");
		
		for (String key : kitchenResults.keySet()) {
		
			if(kitchenResults.get(key).toString().equals("NaN") == false ){
				
				String line = String.format("<LI><pre><big>%-20s %.2f</pre></big>", key, kitchenResults.get(key));
				pw.printf(line);

			}
			
		}

		pw.println("</UL>");
		pw.println("</P>");

	}
	
	private void write_results_for_Laundry(IResult result, PrintWriter pw) {
	
		pw.println();
		pw.println("## Laundry");
		pw.println();
		HashMap<String, Double> laundryResults = result.getAggregateMeterLaundry();
		
		for (String key : laundryResults.keySet()) {
			if(laundryResults.get(key).toString().equals("NaN") == false) {
				
				String line = String.format("* %-20s %.2f\n", key, laundryResults.get(key));
				pw.printf(line);
				
			}
		}
	}
	
	private void write_results_for_Laundry_txt(IResult result, PrintWriter pw) {
		
		pw.println();
		pw.println("Laundry");
		pw.println();
		HashMap<String, Double> laundryResults = result.getAggregateMeterLaundry();
		
		for (String key : laundryResults.keySet()) {
			if(laundryResults.get(key).toString().equals("NaN") == false) {
				
				String line = String.format("·%-20s %.2f\n", key, laundryResults.get(key));
				pw.printf(line);
				
			}
		}
	}
	
	private void write_results_for_Laundry_html(IResult result, PrintWriter pw) {
		
		pw.println("<HR><B><U><BR>Laundry</HR></B></U></BR>");
		pw.println("<P ALIGN = RIGHT>");
		pw.println("<UL>");
		HashMap<String, Double> laundryResults = result.getAggregateMeterLaundry();
		for (String key : laundryResults.keySet()) {
		
			if(laundryResults.get(key).toString().equals("NaN") == false) {
				
				String line = String.format("<LI><pre><big>%-20s %.2f</pre></big>", key, laundryResults.get(key));
				pw.printf(line);

				
			}
		}
		pw.println("</UL>");
		pw.println("</P>");
	}
	
	private void write_results_for_AC(IResult result, PrintWriter pw) {
		
		pw.println();
		pw.println("## AC");
		pw.println();
		HashMap<String, Double> acResults = result.getAggregateMeterAC();
		
		for (String key : acResults.keySet()) {
		
			if(acResults.get(key).toString().equals("NaN") == false) {
				
				String line = String.format("* %-20s %.2f\n", key, acResults.get(key));
				pw.printf(line);
				
			}
		}
	}
	
	private void write_results_for_AC_txt(IResult result, PrintWriter pw) {
		
		pw.println();
		pw.println("AC");
		pw.println();
		HashMap<String, Double> acResults = result.getAggregateMeterAC();
		
		for (String key : acResults.keySet()) {
		
			if(acResults.get(key).toString().equals("NaN") == false) {
				
				String line = String.format("·%-20s %.2f\n", key, acResults.get(key));
				pw.printf(line);
	
			}
		}
	}
	
	private void write_results_for_AC_html(IResult result, PrintWriter pw) {

		pw.println("<HR><B><U><BR>AC</HR></B></U></BR>");
		pw.println("<P ALIGN = RIGHT>");
		pw.println("<UL>");
		HashMap<String, Double> acResults = result.getAggregateMeterAC();
		
		for (String key : acResults.keySet()) {
		
			if(acResults.get(key).toString().equals("NaN") == false) {
				
				String line = String.format("<LI><pre><big>%-20s %.2f</pre></big>", key, acResults.get(key));
				pw.printf(line);
	
			}
		}
	
		pw.println("</UL>");
		pw.println("</P>");

	}

}
