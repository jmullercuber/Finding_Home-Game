import greenfoot.*;

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Actor
{
    
            
    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move();
        Edge();
        
    }    

    private void move()
    {
        setLocation(getX() + 20, getY());
        
    }

    public void Edge()
    {
        if(getX() >= 1000)
        {
            getWorld().removeObject(this);

        }
    }
}
