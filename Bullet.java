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
        temporaryRemoveAsteroidVoid();
        move(20);
        //Edge();

    }

    private void move()
    {
        setLocation(getX() + 20, getY());
    }

    public void Edge()
    {
        // if touching an asteroid, break asteroid and remove self
        // only one asteriod can be broken per bullet
        //Actor touchingAsteroid = getOneIntersectingObject(Asteroid.class);
        //if (touchingAsteroid != null) {
        //    ((Asteroid) touchingAsteroid).breakUp();
        //    getWorld().removeObject(this);
        //}
        // if at the world edge, remove
        if (getX() >= 1000)
        {
            getWorld().removeObject(this);
        }
    }

    public void temporaryRemoveAsteroidVoid()
    {
        Actor asteroid = getOneIntersectingObject(Asteroid.class);
        if(asteroid != null){

            getWorld().removeObject(asteroid);
            getWorld().removeObject(this);
        }
        else
        {
            move();
            if (getX() >= 1000)
            {
                getWorld().removeObject(this);
            }
        }
    }
}
