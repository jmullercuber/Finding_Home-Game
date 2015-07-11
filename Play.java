import greenfoot.*;

/**
 * Write a description of class play here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Play extends World
{
    public static Play play = new Play();
    
    /**
     * Constructor for objects of class play.
     * 
     */
    public Play()
    {
        // Create a new world with 1008x630 cells with a cell size of 1x1 pixels.
        super(1008, 630, 1);
        
        addObject(new Asteroid(), 1500, Greenfoot.getRandomNumber(800));
        addObject(new actorText2(), 50, 400 - 15);
        addObject(new Actor1(), 50, 400);
        addObject(new bombIcon(), 500, 400);
        addObject(new Counter(), 189, 38);
        addObject(new asteroidSuper(), 0, 0);
        
    }
    
    public void act()
    {
        
    }
}
