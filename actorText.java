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
        fireInfo();
        
    }    
    public void fireInfo()
    {
        
        if (Greenfoot.isKeyDown("space")) {
                
                if(timer <= 200) {
                    setImage(new GreenfootImage("Keep in mind that rounds take travelling 70 distance before they're fireable again.", 20, Color.WHITE, Color.BLACK));
                    Greenfoot.delay(200);
                    getWorld().removeObject(this);
                    
                    
                    
                }
                
                
                
            }
    }
    
}
