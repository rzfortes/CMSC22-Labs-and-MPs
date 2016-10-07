/*
 * created by Christine Catubig and Ricafelle Fortes, 10/5/2016 - 10/7/2016
 * 
 */

package inheritance2;


public class Circle extends Shape {
    
    private double radius = 1.0;
    
    public Circle() {
        this.radius = 1.0;
    }
    
    public Circle(double radius) {
        this.radius = radius;
    }
    
    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }
    
    public double getRadius() {
        return radius;
    }
    
    public void setRadius(double radius) {
        this.radius = radius;
    }
    
    @Override
    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }
    
    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
    
    @Override
    public String toString() {
        return "A circle with radius = " + radius + " which is a subclass of " + 
                super.toString();
    }
    
}
