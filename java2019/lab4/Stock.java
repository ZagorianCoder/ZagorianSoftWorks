/* STAVROS ANDRONIS A.M. 3181 LOGIN:cse63181 
   APOSTOLOS-ANASTASIOS AKRIVOS A.M. 4310 LOGIN:cse74310
*/
public class Stock{
	private String stockName;
	private String stockSymbol;
	private double currentValue;
	private double openningValue;


	public Stock(){}


	public Stock(String stockName, double currentValue){
		this.stockName = stockName;
		this.currentValue = currentValue;
	}


	public Stock(String stockName, String stockSymbol, double currentValue, double openningValue){
		this.stockName = stockName;
		this.stockSymbol = stockSymbol;
		this.currentValue = currentValue;
		this.openningValue = openningValue;
	}


	public String getstockName(){
		return stockName;
	}
	
	public String getstockSymbol(){
		return stockSymbol;
	}


	public double getcurrentValue(){
		return currentValue;
	}

	public double getopenningValue(){
		return openningValue;
	}

	public void setstockName(String stockName){
		this.stockName = stockName; 
	}

	public void setstockSymbol(String stockSymbol){
		this.stockSymbol = stockSymbol;
	}

	public void setcurrentValue(double currentValue){
		this.currentValue = currentValue;
	}

	public void setopenningValue(double openningValue){
		this.openningValue = openningValue;
	}

	public String toString(){
		String presentation_object = stockSymbol +":  "+ stockName + " $" + currentValue + " (" + openningValue + ")";
		return presentation_object;
	}

	public boolean equals(Stock other){
		if (this.stockName.equals(other.stockName) && this.stockSymbol.equals(other.stockSymbol) && this.currentValue == other.currentValue && this.openningValue == other.openningValue) {
			return true;
			
		}
		return false;
	}

}