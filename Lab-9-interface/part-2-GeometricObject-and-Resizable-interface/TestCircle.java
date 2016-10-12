/*
 * created by Christine Catubig and Rica Fortes, 10/11/2016 - 10/12/2016
 *
 */
package pkginterface;


public class TestCircle {
    
    public static void main(String[] args) {
        GeometricObject object1 = new Circle(5);
        System.out.println("Area = " + object1.getArea());
        System.out.println("Perimeter = " + object1.getPerimeter());           
    }
    
}
