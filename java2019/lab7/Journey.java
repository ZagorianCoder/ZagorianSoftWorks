/* STAVROS ANDRONIS A.M. 3181 LOGIN:cse63181 
   APOSTOLOS-ANASTASIOS AKRIVOS A.M. 4310 LOGIN:cse74310
*/
public class Journey{
	private String starting_destination;
	private String final_destination;
	private double distance_in_km;
	public Journey(String starting_destination,String final_destination,double distance_in_km){
		this.starting_destination = starting_destination;
		this.final_destination = final_destination;
		this.distance_in_km = distance_in_km;
	}
	public String toString(){
		return starting_destination+" : "+final_destination;
	}
	public void setStart(String starting_destination){
		this.starting_destination=starting_destination;
	}
	public void setFinal(String final_destination){
		this.final_destination=final_destination;
	}
	public void setDistance(double distance_in_km){
		this.distance_in_km=distance_in_km;
	}
	public String getStart(){
		return starting_destination;
	}
	public String getFinal(){
		return final_destination;
	}
	public double getDistance(){
		return distance_in_km;
	}
}