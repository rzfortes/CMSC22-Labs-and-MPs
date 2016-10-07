
public class Triangle extends Shape{
	private double side1, side2, side3;

	public Triangle(){
		side1 = 1.0;
		side2 = 1.0;
		side3 = 1.0;
	}

	public void isCorrectSide(double side1, double side2, double side3){
		if((side1 + side2 + side3) == 180){
			this.side1 = side1;
			this.side2 = side2;
			this.side3 = side3;
		}
		else
			throw new IllegalArgumentException("sides are not valid.");
	
	}

	public Triangle(double side1, double side2, double side3){
		isCorrectSide(side1, side2, side3);
	}

	public Triangle(double side1, double side2, double side3, String color, boolean fill){
		super(color, fill);
		isCorrectSide(side1, side2, side3);		
	}

	public double getArea(){

	}

	public double getPerimeter(){
		return side1 + side2 + side3;
	}
}