import greenfoot.*;

/**
 * Write a description of class creditsButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class creditsButton extends Actor
{
    /**
     * Act - do whatever the creditsButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)){
            Greenfoot.setWorld(new credits());
            
        }
    }    
    }    

