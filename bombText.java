import greenfoot.*;
import java.awt.Color;
/**
 * Write a description of class bombText here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class bombText extends bombIcon
{
    public bombText()
    {
        setImage(new GreenfootImage("Press Q or E to activate the bomb.", 21, Color.WHITE, Color.BLACK));
        
    }
    /**
     * Act - do whatever the bombText wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        Greenfoot.delay(75);
        getWorld().removeObject(this);
    } 
    
}
