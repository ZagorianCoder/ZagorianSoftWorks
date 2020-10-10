/* STAVROS ANDRONIS A.M. 3181 LOGIN:cse63181 
   APOSTOLOS-ANASTASIOS AKRIVOS A.M. 4310 LOGIN:cse74310
*/
public class Aircraft{
	private int code;
	private double individual_cost_of_maintance;
	private Journey journey_object;
	public Aircraft(int code, double individual_cost_of_maintance, Journey journey_object){
		this.code=code;
		this.individual_cost_of_maintance=individual_cost_of_maintance;
		this.journey_object=journey_object;
	}
	public String toString(){
		return journey_object.toString()+", $"+individual_cost_of_maintance;
	}
	public void display(){
		System.out.println(this.toString()+"\n"+journey_object.getDistance());
	}
	public void setCost(double individual_cost_of_maintance){
		this.individual_cost_of_maintance=individual_cost_of_maintance;
	}
	public double getCost(){
		return individual_cost_of_maintance;
	}
}