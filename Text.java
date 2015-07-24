import greenfoot.*;
import java.awt.Color;

/**
 * Write a description of class Text here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Text extends Actor
{
    int delay;
    // Constructor
    public Text(String message, int sz, int dely) {
        setImage(new GreenfootImage(message, sz, Color.WHITE, Color.BLACK));
        this.delay = dely;
    }
    
    /**
     * Act - do whatever the Text wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        Greenfoot.delay(this.delay);
        getWorld().removeObject(this);
    }    
}
