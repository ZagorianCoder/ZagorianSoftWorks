/* STAVROS ANDRONIS A.M. 3181 LOGIN:cse63181 
   APOSTOLOS-ANASTASIOS AKRIVOS A.M. 4310 LOGIN:cse74310
*/
public class MyStockMarket{
	public static void main(String[] args) {
		Stock s1 = new Stock();
		s1.setstockName("Apple Inc.");
		s1.setstockSymbol("AAPL");
		s1.setcurrentValue(191.05);
		s1.setopenningValue(195.34);
		System.out.println(s1.toString());

		Stock s2 = new Stock("Microsoft Corporation", "MSFT", 117.05, 195.34);
		System.out.println(s2.toString());
		System.out.println(s2.getstockName()+" "+s2.getcurrentValue());
		System.out.println("Equal stocks? "+ s2.equals(s1));
		s2.setstockName("Apple Inc.");
		s2.setstockSymbol("AAPL");
		s2.setcurrentValue(191.05);
		System.out.println("Stock Value:" + s2.getcurrentValue());
		System.out.println("Is s1 equal to s2?\n "+ s1.equals(s2));
	}
}