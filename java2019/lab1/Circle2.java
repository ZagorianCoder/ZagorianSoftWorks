/* STAVROS ANDRONIS A.M. 3181 LOGIN:cse63181 
   APOSTOLOS-ANASTASIOS AKRIVOS A.M. 4310 LOGIN:cse74310
*/
import java.lang.Math.*;
import java.util.Scanner;


class Circle2{
	public static void main(String args[]){
		Scanner input = new Scanner(System.in);
		System.out.println("Give me radius r: \n");		
		float r = input.nextFloat();		
		if (r >=	0.0){
			double area;
			double circumference;
			double cube_volume;
			circumference = 2 * Math.PI * r;
			cube_volume = 4/(double)3 * Math.PI * r * r * r;
			area = r * r * Math.PI;
			System.out.printf("The area of a circle with radius %.1f is: %.3f \n",r,area);
			System.out.printf("The circumference of a circle with radius %.1f is: %.3f\n",r,circumference);
			System.out.printf("The cube volume of a sphere with radius %.1f is: %.3f\n",r,cube_volume);
		}else{
			System.out.printf("Error! The radius %.1f is negative.\n",r);
		}
	}
}
