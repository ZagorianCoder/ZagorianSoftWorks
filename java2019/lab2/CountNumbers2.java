/* STAVROS ANDRONIS A.M. 3181 LOGIN:cse63181 
   APOSTOLOS-ANASTASIOS AKRIVOS A.M. 4310 LOGIN:cse74310
*/
import java.util.Scanner;
import java.util.HashMap;


class CountNumbers2{
	public static void main(String[] args) {
				Scanner in = new Scanner(System.in);
				System.out.println("Type a sequence of digits (type stop for exit)");
				String sequence = in.nextLine();
				String [] splited = sequence.split(" ");
				int [] numbers = new int[splited.length-1];
				for (int i=0; i<splited.length-1; i++ ) {
					numbers[i] = Integer.valueOf(splited[i]);
					
				}
				System.out.println("You gave the elements:");
				for (int i=0; i<numbers.length; i++) {

					System.out.println(numbers[i]);
					
				}
				int sum = 0;
				for (int i=0; i<numbers.length ; i++ ) {
					sum += numbers[i];
					
				}
				double average = sum/(double)numbers.length;
				int num_less_than_average = 0;
				for (int i=0; i<numbers.length; i++) {
					if (numbers[i] < average) {

						num_less_than_average++;
						
					}
					
				}
				HashMap<Integer,Integer> Lexiko = new HashMap<Integer,Integer> ();
				for(int arithmos: numbers ){
					if (!Lexiko.containsKey(arithmos)) {
						Lexiko.put(arithmos,1);
						
					}else{
						Lexiko.put(arithmos,Lexiko.get(arithmos)+1);
					}
				}
				System.out.println("The average value is "+average);
				System.out.println("Number of elements lessthan mean:"+num_less_than_average);
				for(int arithmos: Lexiko.keySet()){
					System.out.println(arithmos+":"+Lexiko.get(arithmos));
				}
	}
}