/*
 * created by Christine Catubig and Rica Fortes, 10/11/2016 - 10/12/2016
 *
 */
package pkginterface;


public class MovablePoint implements Movable {

    public int x, y, xSpeed, ySpeed;
    
    public MovablePoint(int x, int y, int xSpeed, int ySpeed){
	this.x = x;
	this.y = y;
	this.xSpeed = xSpeed;
	this.ySpeed = ySpeed;
    }

    @Override
    public String toString(){
	return "This is a movable point.";
    }

    @Override
    public void moveUp(){
	y -= ySpeed;
    }

    @Override
    public void moveDown(){
	y += ySpeed;
    }

    @Override
    public void moveLeft(){
	x -= xSpeed;
    }

    @Override
    public void moveRight(){
	x += xSpeed;
    }
    
}
