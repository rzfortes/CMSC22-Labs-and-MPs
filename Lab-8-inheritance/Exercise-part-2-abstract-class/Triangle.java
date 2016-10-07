/*
 * created by Christine Catubig and Ricafelle Fortes, 10/5/2016 - 10/7/2016
 * 
 */

import java.lang.Math;

public class Triangle extends Shape{
	private double side1, side2, side3;

	public Triangle(){
		side1 = 1.0;
		side2 = 1.0;
		side3 = 1.0;
	}

	public void isValid(double side1, double side2, double side3){
		if((side1 + side2) > side3 || (side3 + side2) > side1 || (side3 + side1) > side2){
			this.side1 = side1;
			this.side2 = side2;
			this.side3 = side3;
		}
		else
			throw new IllegalArgumentException("sides are not valid.");
	
	}

	public Triangle(double side1, double side2, double side3){
		isValid(side1, side2, side3);
	}

	public Triangle(double side1, double side2, double side3, String color, boolean fill){
		super(color, fill);
		isValid(side1, side2, side3);		
	}

	public double getArea(){
		double p = getPerimeter() / 2;
		return Math.sqrt(p * (p - side1) * (p - side2) * (p - side3));
		
	}

	public double getPerimeter(){
		return side1 + side2 + side3;
	}
}

