
public class TestShape{
	public static void main(String[] args){
		Shape shape1 = new Shape();
		System.out.println(shape1);	// green, filled

		Shape shape2 = new Shape("blue", false); 
		System.out.println(shape2 + "\n"); // blue, not filled

		System.out.println("Shape1's color = " + shape1.getColor()); 		// green
		System.out.println("Shape1's color = " + shape1.isFilled()); 		// true
		System.out.println("Shape2's color = " + shape2.getColor()); 		// blue
		System.out.println("Shape2's color = " + shape2.isFilled() + "\n"); // false
		
		shape1.setColor("black");
		shape1.setFilled(false);

		shape2.setColor("violet");
		shape2.setFilled(true);

		System.out.println(shape1);	// black, not filled
		System.out.println(shape2 + "\n"); // violet, filled

		Circle circle1 = new Circle(); 
		System.out.println(circle1); // 1.0 

		Circle circle2 = new Circle(4.5);
		System.out.println(circle2); // 4.5

		Shape circle3 = new Circle(2, "pink", true);
		System.out.println(circle2); // 4.5, pink, filled

		circle1.setRadius(5);
		System.out.println("Circle1's radius = "+ circle1); // 5

		System.out.println("Circle2's area = " + circle2.getArea()); // 
		System.out.println("Circle3's perimeter = " + circle3.getPerimeter()); //

		Shape rec1 = new Rectangle();
		System.out.println(rec1); // width = 1.0, length = 1.0

		Shape rec2 = new Rectangle(2.0, 3.5);
		System.out.println(rec1); // width = 2.0, length = 3.5

		Shape rec3 = new Rectangle(3.1, 4, "indigo", false);
		System.out.println(rec1); // width = 3.1, length = 4, indigo, not filled


	}
}