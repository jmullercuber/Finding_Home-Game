import greenfoot.*;
import java.awt.Color;
/**
 * Write a description of class Radio here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Radio extends PowerUps
{
    /**
     * Act - do whatever the Radio wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (!removeAtEdge()) {
           move(-2);
           touched();
        }
    }
    
    public void touched()
    {
        Actor radio = getOneIntersectingObject(Actor1.class);
        
        if(radio != null) {
            setImage(new GreenfootImage("Captain's Log 527: Patrol 784 lost in the asteroid. Last transmission 'The rocks aren't the only thing here'", 21, Color.WHITE, Color.BLACK));
            Greenfoot.delay(300);
            getWorld().removeObject(this);
        }
    }
   
    
    
}
