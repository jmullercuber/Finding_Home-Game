import greenfoot.*;

/**
 * Write a description of class Ally here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class allyIcon extends PowerUps
{
    /**
     * Act - do whatever the Ally wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
    public allyIcon()
    {
        GreenfootImage image = getImage();
        image.scale(image.getWidth() - 60, image.getHeight() - 20);
        setImage(image);
    }
}
