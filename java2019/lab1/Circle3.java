/* STAVROS ANDRONIS A.M. 3181 LOGIN:cse63181 
   APOSTOLOS-ANASTASIOS AKRIVOS A.M. 4310 LOGIN:cse74310
*/
import java.lang.Math.*;
import java.util.Scanner;


class Circle3{
	public static void main(String args[]){
		Scanner input = new Scanner(System.in);
		System.out.println("Give me radius r: \n");		
		float r = input.nextFloat();		
		if (r >=0.0){
			double area;
			double circumference;
			double cube_volume;
			System.out.println("What do you want to compute (area, circumference, volume, or nothing)? \n");
			String answer1 = input.nextLine();
			while (answer1 != "nothing"){
				switch (answer1){
					case "area":

						area = r * r * Math.PI;
						System.out.printf("The area of a circle with radius %.1f is: %.3f \n",r,area);
						break;
					case "circumference":
						circumference = 2 * Math.PI * r;
						System.out.printf("The circumference of a circle with radius %.1f is: %.3f\n",r,circumference);
						break;
					case "volume":
						cube_volume = 4/(double)3 * Math.PI * r * r * r;
						System.out.printf("The cube volume of a sphere with radius %.1f is: %.3f\n",r,cube_volume);
						break;
					default:
						System.out.println("Invalid input!");
						break;
				}
				System.out.println("What do you want to compute (area, circumference, volume, or nothing)? \n");
				answer1 = input.nextLine();
			}
		}else{
			System.out.printf("Error! The radius %.1f is negative.\n",r);
		}
	}
}
