import greenfoot.*;
import java.lang.Math;

/**
 * Write a description of class Asteroid here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Asteroid extends asteroidSuper
{
    private int number = 0;
    
    public int a = 0;
    private int size;
    public int rotateSpeed;

    public Asteroid()
    {
        this(1);
    }
    
    public Asteroid(int sz) {
        //setImage( getImage() );
        size = sz;
        rotateSpeed = Greenfoot.getRandomNumber(4);
        asteroidSpeed = Greenfoot.getRandomNumber(4);
        setImage(size + ".png");
    }

    /**
     * Act - do whatever the Asteroid wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        move();
        checkEdge();
        
        a = Greenfoot.getRandomNumber(4);
    }

    /**
     * This moves the object across screen. Speed can change by level. Base speed -3.
     */
    public void move()
    {
        // drift
        setLocation(getX() - (asteroidSpeed + 2), getY());
        // slowly rotate counter-clockwise
        turn(-rotateSpeed);
    }

    /**
     * Removes object at screen's edge. asteroidDelay changes by level also to add difficulty.
     */
    public void checkEdge()
    {
        if (getX() <= 0) {
            getWorld().removeObject(this);
        }
    }
    
    /*
     * TODO: Needs implementation for adding points to score when destroyed.
     */
    public void breakUp() {
        // if not at the minimum size
        if (this.size < 6) {
            // generate a random number of smaller asteroids
            for (int i=0; i < 1+Greenfoot.getRandomNumber(2); i++) {
                // one size smaller
                Asteroid a = new Asteroid(this.size + 1);
                // figure out a location for the new asteroid within a 25 cell radius from origin
                int randRadius = Greenfoot.getRandomNumber(25);
                double randAngle = Math.toRadians(Greenfoot.getRandomNumber(360));
                // add to the world, at that location
                getWorld().addObject(
                    a,
                    this.getX()+(int)( randRadius * Math.sin(randAngle) ),
                    this.getY()+(int)( randRadius * Math.cos(randAngle) )
                );
            }
        }
        getWorld().removeObject(this);
    }
}
