/* STAVROS ANDRONIS A.M. 3181 LOGIN:cse63181 
   APOSTOLOS-ANASTASIOS AKRIVOS A.M. 4310 LOGIN:cse74310
*/
public class Propeller extends Aircraft{
	private double flight_rad;
	private double travelled_km = 0;
	private Aircraft airplane2;
	public Propeller (double flight_rad, Aircraft airplane2, int code, double cost_of_maintance, Journey journey_object){
		super(code, cost_of_maintance, journey_object);
		if (journey_object.distance > flight_rad) {
			System.out.println("This propeller aircraft cannot fly for the travel: ".journey_object.toString());
		
		}else{
			travelled_km += journey_object.getDistance()+50;
		}
	}
	public double computeCost(){
		double cost_of_maintance = airplane2.getCost()+0.1*travelled_km;
		return cost_of_maintance;
	}
	public String toString(){
		return airplane2.getCost()+", maximum flight-range: "+flight_rad+"km, Maintenance cost: $"+cost_of_maintance);
	}
}