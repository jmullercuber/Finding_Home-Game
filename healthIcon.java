import greenfoot.*;

/**
 * Optional class. Not sure if neccessary or not.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class healthIcon extends PowerUps
{
    /**
     * Act - do whatever the Health wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        move(moveSpeed);
        removeAtEdge();
    }

    public healthIcon()
    {
        GreenfootImage image = getImage();
        //image.scale(image.getWidth() - 40, image.getHeight() - 40);
        setImage(image);
    }
}
