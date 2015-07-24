import greenfoot.*;
import java.awt.Color;

/**
 * Write a description of class Counter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DistanceCounter extends Counter
{
    public DistanceCounter() {
        super("Distance From Home : ", 39090);
    }
    
    /**
     * Act - do whatever the Counter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.act();
        count -= 1;
        if(count <= 0) {
            Greenfoot.setWorld(new Win());
        }
    }    
}
