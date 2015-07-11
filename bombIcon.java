import greenfoot.*;

/**
 * Write a description of class BombIcon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class bombIcon extends PowerUps
{
    
    /**
     * Act - do whatever the BombIcon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        Edge();
        move(-2);
        if( timer <= 1000) {
        inform();
       } 
    }
    /**
     * Removes object at screen's edge. asteroidDelay changes by level also to add difficulty.
     */
    public void Edge()
    {
        if(getX() <= 0)
        {
            getWorld().removeObject(this);
            
        }
    }
    public void inform()
    {
        Actor player = getOneIntersectingObject(Actor1.class);
        if( player != null) {
            getWorld().addObject(new bombText(),getX(), getY() );
            getWorld().removeObject(this);
        }
    }
}
