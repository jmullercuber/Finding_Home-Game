import greenfoot.*;

/**
 * Write a description of class PowerUps here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class PowerUps extends Actor
{
    public int moveSpeed;
    
    public PowerUps(int movespeed) {
        this.moveSpeed = movespeed;
    }
    
    public PowerUps() {
        this(-4);
    }
   
    /**
     * Act - do whatever the BombIcon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (!removeAtEdge()) {
            move(moveSpeed);
            touched();
        }
    }   

    /**
     * Removes object at screen's edge. asteroidDelay changes by level also to add difficulty.
     */
    public boolean removeAtEdge()
    {
        if (getX() <= 0)
        {
            getWorld().removeObject(this);
            return true;
        }
        return false;
    }
    
    public abstract void touched();
}
