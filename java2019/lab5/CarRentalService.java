/* STAVROS ANDRONIS A.M. 3181 LOGIN:cse63181 
   APOSTOLOS-ANASTASIOS AKRIVOS A.M. 4310 LOGIN:cse74310
*/
public class CarRentalService{
	private Client customer;
	private String type_of_plan;
	private int rental_time;
	private int miles;


	public CarRentalService(Client customer , String type_of_plan){
		this.customer = customer;
		this.type_of_plan = type_of_plan;
		
	}
	public boolean bookCar(Client customer, int rental_time, int miles, String type_of_plan ){
		if (customer.check_plan(rental_time+this.rental_time,miles+this.miles,type_of_plan, customer)) {
			this.rental_time += rental_time;
			this.miles += miles;  
			customer.setRentTimes(customer.getRentTimes()+1);
			return true;
		}
		return false;
	}
	private boolean check_plan(int rental_time,int miles,String type_of_plan, Client customer){
		if (type_of_plan.equals("Basic") && rental_time > 100 && miles > 200 && customer.getRentTimes() < 5) {

			return false;
			
		}
		if (type_of_plan.equals("Advanced") && rental_time > 200 && miles > 400 && customer.getRentTimes() < 5) {
			return false;
		}
		if (type_of_plan.equals("Premium") && rental_time > 400 && miles > 800 && customer.getRentTimes() < 5) {
			return false;
		}
		if (type_of_plan.equals("Gold") && rental_time > 600 && miles > 1600 && customer.getRentTimes() < 5) {
			return false;
		}
		return true;
	}
	public boolean  bookCar(Client client){
		if (client.getRentTimes() > 5) {

			this.rental_time +=  30;
			this.miles += 50;
			int positive_rent_times = client.getRentTimes() - 5;
			if (positive_rent_times < 0) {

				positive_rent_times = 0;
				
			}
			client.setRentTimes(positive_rent_times)
			return true;
			
		}
		return false;
		


	} 
	public boolean pickAPlan(Client client, type_of_plan){

		if (client.getRentTimes() > 5) {

			this.type_of_plan = type_of_plan;
			return true;
			
		}
		return false;

	}
	public String toString(){

		return customer.getName()+","+customer.getArithmosTaytotitas()+":Plan "+type_of_plan+"; "+rental_time+" mins "+miles+" miles"

	}

}
