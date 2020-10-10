/* STAVROS ANDRONIS A.M. 3181 LOGIN:cse63181 
   APOSTOLOS-ANASTASIOS AKRIVOS A.M. 4310 LOGIN:cse74310
*/
class MyList{
	private int[] list;
	private int capacity;
	private int numOfElements=0;
	public MyList(int capacity){
		this.capacity=capacity;
		list = new int[capacity];

	}
	public boolean insert(int x){
		if (numOfElements != capacity) {

			list[numOfElements] = x;
			numOfElements ++;
			return true;

			
		}
		return false;
	}
	public boolean remove(int x){
		for (int i=0;i<numOfElements ; i++ ) {
			if (x==list[i]) {

				for (int j=x; j<numOfElements-1 ; j++) {

					list[j]=list[j+1];


					
				}
				list[numOfElements-1]=0;
				return true;
				
			}
			
		}
		return false;
	}
	public void printList(){
		for (int i=0; i<numOfElements; i++ ) {

			System.out.println(list[i]);
			
		}
	}
	public void findMin(){
		int min_index = list[0];
		for (int i=1; i<numOfElements; i++ ) {
			if (min_index>list[i]) {

				min_index=list[i];
				
			}

			
		}
		System.out.println("The minimum index of the list is"+min_index);
	}
	public void findMean(){
		int sum=0;
		for (int i=0; i<numOfElements; i++) {

			sum += list[i];
			
		}
		double average = sum/(double)numOfElements;
		System.out.println("the average of the list is"+average);

	}
	public void setNumofelements(int x){
		numOfElements = x;
	}
	public int getNumOfElements(){
		return numOfElements;
	}
}