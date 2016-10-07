/*
 * created by Christine Catubig and Ricafelle Fortes, 10/5/2016 - 10/7/2016
 * 
 */
package inheritance;


public class Rectangle extends Shape {

    /*public Rectangle(String color, boolean filled) {
        super(color, filled);
    }*/
    
    private double width = 1.0;
    private double length = 1.0;
    
    public Rectangle() {
        
    }
    
    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }
    
    public Rectangle(double width, double length, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }
    
    public double getWidth() {
        return width;
    }
    
    public void setWidth(double width) {
        this.width = width;
    }
    
    public double getLength() {
        return length;
    }
    
    public void setLength(double length) {
        this.length = length;
    }
    
    public double getArea() {
        return (width * length);
    }
    
    public double getPerimeter() {
        return (2 * (length + width));
    }
    
    @Override
    public String toString() {
        return "A Rectangle with width = " + width + " and length = " + length +
                ", which is a subclass of " + super.toString();
    }
    
}
