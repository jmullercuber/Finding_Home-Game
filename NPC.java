import greenfoot.*;

/**
 * Write a description of class NPC here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NPC extends Actor1
{
   private int movin = 0;
   
    private int movinUp = 0;
    private int movinDown = 0;
    private int movinRight = 0;
    private int movinLeft = 0;
    /**
     * Act - do whatever the NPC wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        drift();
        npcshoot();
    }    
    public NPC()
    {
        GreenfootImage image = getImage();
        image.scale(image.getWidth() - 260, image.getHeight() - 53);
        setImage(image);
    }
 
    /**
     * The NPC ship needs to be able to move on its own according to where the asteroids are around it
     * Basically it can't move randomllu, it has to be somewhat smart about it.
     */
    public void npcmovement()
    {
        if( Greenfoot.isKeyDown("right"))
        {
            setLocation(getX() + 2, getY());
            setImage("Ship Engine On.png");
            GreenfootImage image = getImage();
            image.scale(image.getWidth() - 350, image.getHeight() - 60);
            setImage(image);
            movin = 1;
            movinRight = 1;
            movinUp = 0;
            movinDown = 0;
            movinLeft = 0;
            //change image to Engine On, else Engine Off
        }
        if( Greenfoot.isKeyDown("left"))
        {
            setLocation(getX() - 2, getY());
            setImage("Ship Engine Off.png");
            GreenfootImage image = getImage();
            image.scale(image.getWidth() - 260, image.getHeight() - 53);
            setImage(image);
            movinLeft = 1;
            movinUp = 0;
            movinDown = 0;
            movinRight = 0;
        }
        if( Greenfoot.isKeyDown("Up"))
        {
            setLocation(getX(), getY() - 2);
            movin = 1;
            movinUp = 1;
            movinLeft = 0;
            movinDown = 0;
            movinRight = 0;
        }
        if(Greenfoot.isKeyDown("Down"))
        {
            setLocation(getX(), getY() + 2);
            movin = 1;
            movinDown = 1;
            movinUp = 0;
            movinLeft = 0;
            movinRight = 0;
        }
        if( Greenfoot.isKeyDown("d"))
        {
            setLocation(getX() + 2, getY());
            setImage("Ship Engine On.png");
            GreenfootImage image = getImage();
            image.scale(image.getWidth() - 350, image.getHeight() - 60);
            setImage(image);
            movin = 1;
            movinRight = 1;
            movinUp = 0;
            movinDown = 0;
            movinLeft = 0;
        }
        if( Greenfoot.isKeyDown("a"))
        {
            setLocation(getX() - 2, getY());
            setImage("Ship Engine Off.png");
            GreenfootImage image = getImage();
            image.scale(image.getWidth() - 260, image.getHeight() - 53);
            setImage(image);
            movinLeft = 1;
            movinUp = 0;
            movinDown = 0;
            movinRight = 0;
        }
        if( Greenfoot.isKeyDown("w"))
        {
            setLocation(getX(), getY() - 2);
            movin = 1;
            movinUp = 1;
            movinDown = 0;
            movinLeft = 0;
            movinRight = 0;
        }
        if(Greenfoot.isKeyDown("s"))
        {
            setLocation(getX(), getY() + 2);
            movin = 1;
            movinDown = 1;
            movinUp = 0;
            movinLeft = 0;
            movinRight = 0;
        }
        if(movin == 0) {
           setImage("Ship Engine Off.png");
            GreenfootImage image = getImage();
            image.scale(image.getWidth() - 260, image.getHeight() - 53);
            setImage(image);
          
        }
        movin = 0;
    }
}
