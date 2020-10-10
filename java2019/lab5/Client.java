/* STAVROS ANDRONIS A.M. 3181 LOGIN:cse63181 
   APOSTOLOS-ANASTASIOS AKRIVOS A.M. 4310 LOGIN:cse74310
*/
public class Client{

	private String name;
	private String arithmos_taytotitas;
	private int rent_times = 0;

	public Client(String name, String arithmos_taytotitas ) {
		this.name = name ;
		this.arithmos_taytotitas = arithmos_taytotitas;
	}

	public String getName(String name){
		return name;
	}
	public String getArithmosTaytotitas(String arithmos_taytotitas){
		return arithmos_taytotitas;
	}
	public String getRentTimes(int rent_times){
		return rent_times;
	}
	public void setRentTimes(int rent_times){
		this.rent_times = rent_times;
	}
	public String toString(){
		String name_and_ID = name + ", "+arithmos_taytotitas;
		return name_and_ID;
	}



}
