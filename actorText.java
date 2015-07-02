import greenfoot.*;
import java.awt.Color;
/**
 * Write a description of class actorText here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class actorText extends Actor1
{
    /**
     * Act - do whatever the actorText wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
         
        getWorld().removeObject(this);
    }    
    public actorText()
    {
        setImage(new GreenfootImage("You are the only survivors of the wave. Only home knows the answers. Other survivors will join you if they lived to tell the tale.", 21, Color.WHITE, Color.BLACK));
            Greenfoot.delay(200);
           
    }
}
