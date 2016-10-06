package inheritance2;

public abstract class Shape {

    protected String color = "red";
    protected boolean filled = true;
    
    public Shape() {
        color = "green";
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
    
    public abstract double getArea();
    public abstract double getPerimeter();
    
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
        
        Shape s1 = new Circle(5.5, "RED", false); // Upcast Circle to Shape
        System.out.println(s1); // which version? Answer: Circle overloaded constructor (the third one)
        System.out.println(s1.getArea()); // which version? Answer: the abstract method of getArea in Circle class
        System.out.println(s1.getPerimeter()); // which version? Answer: the abstract method of getPerimeter in Circle class
        System.out.println(s1.getColor());
        System.out.println(s1.isFilled());
        
        /* error because getRadius in Circle class is not an abstract method. 
        to fix this error, make the getRadius also as an abstract method*/
        //System.out.println(s1.getRadius());
        
        Circle c1 = (Circle)s1; // Downcast back to Circle
        System.out.println(c1);
        System.out.println(c1.getArea());
        System.out.println(c1.getPerimeter());
        System.out.println(c1.getColor());
        System.out.println(c1.isFilled());
        System.out.println(c1.getRadius());
        
        // error because Shape class is the abstract class itself. If a class is declared abstract, it cannot be instantiated.
        //Shape s2 = new Shape(); 
        
        Shape s3 = new Rectangle(1.0, 2.0, "RED", false); // Upcast
        System.out.println(s3);
        System.out.println(s3.getArea());
        System.out.println(s3.getPerimeter());
        System.out.println(s3.getColor());
        
        // again, error because "datatype" is Shape which is the abstract class itself.
        // to be able to fix this, we should make this method an abstract in the abstract class and override it in the Rectangle class
        //System.out.println(s3.getLength());
        
        Rectangle r1 = (Rectangle)s3; // downcast
        System.out.println(r1);
        System.out.println(r1.getArea());
        System.out.println(r1.getColor());
        System.out.println(r1.getLength());
        Shape s4 = new Square(6.6); // Upcast
        System.out.println(s4);
        System.out.println(s4.getArea());
        System.out.println(s4.getColor());
        
        // again, same error because getSide in Square class is not an abstract method
        //System.out.println(s4.getSide());
        
        // Take note that we downcast Shape s4 to Rectangle ,
        // which is a superclass of Square, instead of Square
        Rectangle r2 = (Rectangle)s4;
        System.out.println(r2);
        System.out.println(r2.getArea());
        System.out.println(r2.getColor());
        
        // again, getSide in Square class is not an abstract method
        //System.out.println(r2.getSide());
        
        System.out.println(r2.getLength());
        // Downcast Rectangle r2 to Square
        Square sq1 = (Square)r2;
        System.out.println(sq1);
        System.out.println(sq1.getArea());
        System.out.println(sq1.getColor());
        System.out.println(sq1.getSide());
        System.out.println(sq1.getLength());
    }
    
}
