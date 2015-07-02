import greenfoot.*;

/**
 * Write a description of class PowerUps here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PowerUps extends Actor
{
    public int moveSpeed = -4;
    /**
     * Act - do whatever the PowerUps wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    

    public void removeAtEdge()
    {
        {
            if(getX() <= 0)
            {
                getWorld().removeObject(this);
            }
        }
    }
}
