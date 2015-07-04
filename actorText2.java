import greenfoot.*;
import java.awt.Color;
/**
 * Write a description of class actorText2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class actorText2 extends Actor1
{
    /**
     * Act - do whatever the actorText2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        drift();
        movement();
    } 
    public actorText2()
    {
        setImage(new GreenfootImage("You", 12, Color.WHITE, Color.BLACK));
    }
}
