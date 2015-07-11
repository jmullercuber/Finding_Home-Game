import greenfoot.*;
import java.awt.Color;

/**
 * Write a description of class Counter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Counter extends Actor
{
    public int distance = 39090;
    /**
     * Act - do whatever the Counter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setImage(new GreenfootImage("Distance From Home : " + distance, 32, Color.WHITE, Color.BLACK));
        distance = distance - 1;
        if(distance <= 0) {
            Greenfoot.setWorld(new Win());
        }
        else {
            distance = distance - 1;
        }
    }    
}
