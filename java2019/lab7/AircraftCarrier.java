/* STAVROS ANDRONIS A.M. 3181 LOGIN:cse63181 
   APOSTOLOS-ANASTASIOS AKRIVOS A.M. 4310 LOGIN:cse74310
*/
public class AircraftCarrier{
	public static void main(String[] args) {
		Journey travel1 = new Journey("Athens","Ioannina",311.0);
		Journey travel2 = new Journey("Athens","Frankfurt",2430.90);
		Journey travel3 = new Journey("Athens","New York",7919.03);
		Aircraft [] airport = new Aircraft[4];
		for (int i=0; i<=0; i++) {
			airport[i] = new Aircraft(1, 2000, travel1);
			airport[i+1] = new Propeller(2, 2500, travel2,4000);
			airport[i+2] = new Propeller(3, 2600, travel3,5000);
			airport[i+3] = new Boeing(4, 2800, travel3,10000);	
		}
		for(Aircraft a : airport){
			System.out.println(airport[a]);
		}
	}
}