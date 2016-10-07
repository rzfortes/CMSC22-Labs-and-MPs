/*
 * created by Christine Catubig and Ricafelle Fortes, 10/5/2016 - 10/7/2016
 * 
 */

package inheritance;


public class Shape {
    
    private String color = "red";
    boolean filled = true;
    
    public Shape() {
        color = "green";
        // consult if kinahanglan pa ni siya i-initialize balik
        filled = true;
    }
    
    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }
    
    public String getColor() {
        return color;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    
    public boolean isFilled() {
        return filled;
    }
    
    public void setFilled(boolean filled) {
        this.filled = filled;
    }
    
    @Override
    public String toString() {
        String ans;
        if(isFilled()) {
            ans = "filled";
        } else {
            ans = "not filled";
        }
        return String.format("A Shape with color of %s is %s.", color, ans);
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
