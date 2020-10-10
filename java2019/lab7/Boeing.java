/* STAVROS ANDRONIS A.M. 3181 LOGIN:cse63181 
   APOSTOLOS-ANASTASIOS AKRIVOS A.M. 4310 LOGIN:cse74310
*/
public class Boeing extends Aircraft{
	private double flight_rad;
	private double travelled_km = 0;
	private Aircraft airplane1;
	public Boeing (double flight_rad, Aircraft airplane1, int code, double cost_of_maintance, Journey journey_object){
		super(code, cost_of_maintance, journey_object);
		if (journey_object.distance > flight_rad) {
			System.out.println("This boeing aircraft cannot fly for the travel: ".journey_object.toString());
			
		}else{
		travelled_km += journey_object.getDistance()+50;
		}
	}
	public double computeCost(){
		double cost_of_maintance = airplane1.getCost()+0.2*travelled_km;
		return cost_of_maintance;
	}
	public String toString(){
		return airplane1.toString()+", maximum flight-range: "+flight_rad+"km, Maintenance cost: $"+cost_of_maintance);
	}
}