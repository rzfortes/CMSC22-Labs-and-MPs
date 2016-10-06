/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inheritance2;

/**
 *
 * @author rdfortes
 */
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
    
    @Override
    public double getArea() {
        return (width * length);
    }
    
    @Override
    public double getPerimeter() {
        return (2 * (length + width));
    }
    
    @Override
    public String toString() {
        return "A Rectangle with width = " + width + " and length = " + length +
                ", which is a subclass of " + super.toString();
    }
    
}
