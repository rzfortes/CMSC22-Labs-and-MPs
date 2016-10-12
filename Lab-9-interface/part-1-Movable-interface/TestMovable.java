/*
 * created by Christine Catubig and Rica Fortes, 10/11/2016 - 10/12/2016
 *
 */
package pkginterface;


public class TestMovable {
    
    public static void main(String[] args){
	Movable m1 = new MovablePoint(5, 6, 10, 10);
	System.out.println(m1);
	m1.moveLeft();
	System.out.println(m1);

	Movable m2 = new MovableCircle(2, 1, 2, 2, 20);
	System.out.println(m2);
	m2.moveRight();
	System.out.println(m2);
    }
    
}
