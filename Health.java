import greenfoot.*;

/**
 * Write a description of class Health here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Health extends Actor
{
    /**
     * Act - do whatever the Health wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        move(-4);
        
        {
            if(getX() <= 0)
            {
                getWorld().removeObject(this);

            }
        }
    }

    public Health()
    {
        GreenfootImage image = getImage();
        image.scale(image.getWidth() - 40, image.getHeight() - 40);
        setImage(image);
    }
}
