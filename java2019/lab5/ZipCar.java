public class ZipCar{
	public static void main(String[] args) {
		Client customer = new Client("Stavros Andronis","ΑΖ913161");
		CarRentalService rentCar = new CarRentalService(customer, "Advanced");
		System.out.println(rentCar);
		for(inti=0; i<6; i++) {
			rentCar.bookCar(customer, "Advanced", 20, 30);
		}
		customer.pickAPlan(customer,"Gold")

	}
}