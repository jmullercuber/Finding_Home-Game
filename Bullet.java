import greenfoot.*;

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Actor
{
    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (!checkAsteroid()) {
            move();
            checkEdge();
        }
    }

    private void move()
    {
        setLocation(getX() + 20, getY());
    }

    public boolean checkEdge()
    {
        // if at the world edge, remove
        if (getX() >= 1000) {
            getWorld().removeObject(this);
            return true;
        }
        return false;
    }

    public boolean checkAsteroid()
    {
        // if touching an asteroid, break asteroid and remove self
        // only one asteriod can be broken per bullet
        Actor asteroid = getOneIntersectingObject(Asteroid.class);
        if (asteroid != null){
            ((Asteroid)asteroid).breakUp();
            getWorld().removeObject(this);
            return true;
        }
        return false;
    }
}
