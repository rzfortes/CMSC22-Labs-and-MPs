/*
 * created by Christine Catubig and Rica Fortes, 10/11/2016 - 10/12/2016
 *
 */
package pkginterface;


public class Circle implements GeometricObject {

    protected double radius = 1.0;
    
    public Circle(double radius){
        this.radius = radius;
    }
    
    @Override
    public double getPerimeter(){
        return 2 * Math.PI * radius;
    }
    
    @Override
    public double getArea(){
        return Math.PI * Math.pow(radius, 2);
    }
    
}
