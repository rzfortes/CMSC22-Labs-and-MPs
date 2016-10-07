/*
 * created by Christine Catubig and Ricafelle Fortes, 10/5/2016 - 10/7/2016
 * 
 */

package inheritance2;


public class Square extends Rectangle {
    
    public Square() {   
    }
    
    public Square(double side) {
        super(side, side);
    }
    
    public Square(double side, String color, boolean filled) {
        super(side, side, color, filled);
    }
    
    public double getSide() {
        // can be either width or length
        return super.getWidth();  
    }
    
    public void setSide(double side) {
        // can be either length or width
        super.setLength(side);
    }
    
    // getArea() and getPerimeter() don't need to override because they both 
    // (rectangle and square) have the same formula.
    
    @Override
    public void setWidth(double side) {
        super.setLength(side);
    }
    
    @Override
    public void setLength(double side) {
        super.setWidth(side);
    }
    
    @Override
    public String toString() {
        return "A Square with side = " + super.getLength() + ", which is a subclass of " + 
                super.toString();
    }
    
}
