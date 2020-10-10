/* STAVROS ANDRONIS A.M. 3181 LOGIN:cse63181 
   APOSTOLOS-ANASTASIOS AKRIVOS A.M. 4310 LOGIN:cse74310
*/
import java.util.*;

class TryMyList{
	public static void main(String[] args) {
		int N=10;
		MyList list = new MyList(N);


		System.out.println("Removed: "+ list.remove(5));
		Scanner input = new Scanner(System.in);
		System.out.println("Give me 5 numbers:");
		while (input.hasNextInt()) {
			for (int i=1; i<=5; i++ ) {

				list.insert(input.nextInt());
				
			}
			System.out.println("Number of elements in the list: "+list.getNumOfElements());
			list.printList();
			list.findMin();
			list.findMean();
			System.out.println("Which element do you want to remove?");
			System.out.println("Removed: " + list.remove(input.nextInt()));
			System.out.println("Number of elements in the list: " + list.getNumOfElements ());
			list.printList();
			System.out.println("Give me 5 numbers:");	
		}

	}
}