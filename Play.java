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
        super(1008, 800, 1);
        addObject(new Asteroid(), 1500, Greenfoot.getRandomNumber(400));
        addObject(new Actor1(), 50, 400);
        
        addObject(new Counter(), 189, 38);
    }
    
    public void act()
    {
        
    }
}
