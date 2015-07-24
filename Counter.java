import greenfoot.*;
import java.awt.Color;

/**
 * Write a description of class Counter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Counter extends Actor
{
    protected String text;
    protected int count;
    
    protected Counter(String txt, int c) {
        text = txt;
        count = c;
    }
    
    /**
     * Act - do whatever the Counter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        setImage(new GreenfootImage(text + count, 32, Color.WHITE, Color.BLACK));
    }
    
    public int increment(int change) {
        count += change;
        return count;
    }
}
