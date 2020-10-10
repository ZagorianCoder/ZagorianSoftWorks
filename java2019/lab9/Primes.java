/* STAVROS ANDRONIS A.M. 3181 LOGIN:cse63181 
*/
import java.util.ArrayList;
import java.util.Iterator;


public class Primes{
	public static void main(String[] args) {
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		for (Integer i=2; i<=100 ; i++) {
			numbers.add(i);
		}
		Iterator<Integer> it = numbers.listIterator();
		for (Integer i=0; i < numbers.size(); i++) {
			it = numbers.listIterator(i+1);
			while(it.hasNext()){
			   if (it.next() % numbers.get(i) == 0) {
			   		it.remove();
			   }
			}
		}
		it = numbers.listIterator();
		System.out.println("The prime numbers from 2 to 100 are:");
		while(it.hasNext()){
			System.out.print(it.next()+" ");
		}
		System.out.println();
	}
	
}