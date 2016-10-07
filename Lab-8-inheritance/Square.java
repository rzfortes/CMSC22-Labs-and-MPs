/*
 * created by Christine Catubig and Ricafelle Fortes, 10/5/2016 - 10/7/2016
 * 
 */

package inheritance;


public class Square extends Rectangle {

    /*public Square(double width, double length) {
        super(width, length);
    }*/
    
    private double side = 1.0;
    
    public Square() {
        
    }
    
    public Square(double side) {
        super(side, side);
    }
    
    public Square(double side, String color, boolean filled) {
        super(side, side, color, filled);
    }
    
    public double getSide() {
        return side;
    }
    
    public void setSide(double side) {
        this.side = side;
    }
    
    @Override
    public void setWidth(double side) {
        this.side = side;
    }
    
    @Override
    public void setLength(double side) {
        this.side = side;
    }
    
    @Override
    public String toString() {
        return "A Square with side = " + side + ", which is a subclass of " + 
                super.toString();
    }
    
}
