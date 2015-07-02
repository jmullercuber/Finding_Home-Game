import greenfoot.*;

/**
 * Write a description of class creditsButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class creditsButton extends Button
{
    public void onClick()
    {
        Greenfoot.setWorld(Credits.credits);
    }
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)){
            Greenfoot.setWorld(new Credits());
            
        }
    }   
}

