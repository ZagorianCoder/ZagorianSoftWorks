/* STAVROS ANDRONIS A.M. 3181 LOGIN:cse63181 
   APOSTOLOS-ANASTASIOS AKRIVOS A.M. 4310 LOGIN:cse74310
*/
import java.lang.Math;

interface ComparableShape{
	public int compareAreaToPerimeterRatio(ComparableShape shape);
}
abstract class Shape implements ComparableShape{
	String name;
	public Shape(){}
	public Shape(String name){
		this.name = name;
	}
	public abstract double perimeter();
	public abstract double area();
	public int compareAreaToPerimeterRatio(ComparableShape shape){
		if (this.area()/this.perimeter() == ((Shape)shape).area()/((Shape)shape).perimeter()) {
			return 0;
		}
		else if(this.area()/this.perimeter() > ((Shape)shape).area()/((Shape)shape).perimeter()){
			return 1;
		}
		else{
			return -1;
		}
	}
	public void print(){
		System.out.println("The name of shape is " + name + " with a perimeter of "+ this.perimeter() + " and an area of " + this.area());
	}

}
class Rectangle extends Shape{
	private double width;
	private double length;
	public Rectangle(double width, double length, String name){
		super(name);
		this.width = width;
		this.length = length;
	}
	public double perimeter(){
		return 2*width + 2*length;
	}
	public double area(){
		return width*length;
	}
}
class Circle extends Shape{
	private double r;
	public Circle(double r, String name){
		super(name);
		this.r = r;
	}
	public double perimeter(){
		return 2*Math.PI*r;
	}
	public double area(){
		return Math.PI*r*r;
	}
}
public class ShapeTest{
	public static void main(String[] args) {
		ComparableShape[] shapes = new ComparableShape[4];
		shapes[0] = new Rectangle(1.3, 2.4, "Rectangle1");
		shapes[1] = new Rectangle(1.8, 5.4, "Rectangle2");
		shapes[2] = new Circle(1.4, "Circle1");
		shapes[3] = new Circle(4.0,"Circle2");
		ComparableShape max_shape = shapes[0];
		for (int i=0; i < 4; i++) {
			if (shapes[i].compareAreaToPerimeterRatio(max_shape) == 1) {
				max_shape = shapes[i];
			}
			((Shape)shapes[i]).print();
		}
		((Shape)max_shape).print();
	}
}