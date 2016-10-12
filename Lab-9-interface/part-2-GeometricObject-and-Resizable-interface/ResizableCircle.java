/*
 * created by Christine Catubig and Rica Fortes, 10/11/2016 - 10/12/2016
 *
 */
package pkginterface;


public class ResizableCircle extends Circle implements Resizable {

    public ResizableCircle(double radius) {
        super(radius);
    }
    
    @Override
    public void resize(int percent){
        radius += radius * (percent / 100);
    }
    
}