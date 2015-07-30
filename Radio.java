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
    public Radio() {
        super(-2);
    }
    
    public void touched()
    {
        Actor player = getOneIntersectingObject(Actor1.class);
        
        if(player != null) {
            setImage(new GreenfootImage("Captain's Log 527: Patrol 784 lost in the asteroid. Last transmission 'The rocks aren't the only thing here'", 21, Color.WHITE, Color.BLACK));
            Greenfoot.delay(300);
            getWorld().removeObject(this);
        }
    }
}
