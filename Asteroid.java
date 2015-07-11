import greenfoot.*;

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
    public int rotateSpeed;

    /**
     * Act - do whatever the Asteroid wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        set();
        Edge();
        
        
        // slowly rotate counter-clockwise
        turn(-rotateSpeed);
        a = Greenfoot.getRandomNumber(4);
        
    }

    public Asteroid()
    {
        GreenfootImage image = getImage();
        
        setImage(image);
        rotateSpeed = Greenfoot.getRandomNumber(4);
        asteroidSpeed = Greenfoot.getRandomNumber(4);
    }

    /**
     * This moves the object across screen. Speed can change by level. Base speed -3.
     */
    public void set()
    {
        setLocation(getX() - (asteroidSpeed + 2), getY());
    }

    /**
     * Removes object at screen's edge. asteroidDelay changes by level also to add difficulty.
     */
    public void Edge()
    {
        if(getX() <= 0)
        {
            getWorld().removeObject(this);
            
        }
    }
    
    public void breakUp() {
    
    }
    /*
     * Needs void for the asteroid to break into smaller pieces and eventually be destroyed.
     * Needs void for adding points to score when destroyed.
     */
}
