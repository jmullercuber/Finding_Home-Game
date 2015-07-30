import greenfoot.*;
import java.awt.Color;

/**
 * Currently has no purpose.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Patrol extends NPC
{
    
    /**
     * Act - do whatever the Patrol wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        int x = getX();
        if(x >= 500){
            setLocation(getX() - 1, getY());
            turn(-1);
        }
    }    
}
