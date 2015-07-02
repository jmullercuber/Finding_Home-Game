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
    int tillDeath = 750;
    int tutorial = 1;
    public int go = 0;

    /**
     * Act - do whatever the NPC wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        drift();
        if(tutorial == 1){
            tutorial();
            tutorial = 2;
        }
        npcshoot();
        npcmovement();
    }    

    public NPC()
    {
        GreenfootImage image = getImage();
        //image.scale(image.getWidth() - 260, image.getHeight() - 53);
        setImage(image);
        delay = 10;
    }

    /**
     * The NPC ship needs to be able to move on its own according to where the asteroids are around it
     * Basically it can't move randomllu, it has to be somewhat smart about it.
     */
    public void npcmovement()
    {
        if ( Greenfoot.isKeyDown("right") | Greenfoot.isKeyDown("d") )
        {
            setLocation(getX() - 2, getY());
            setImage("Ship Engine On.png");
            GreenfootImage image = getImage();
            //image.scale(image.getWidth() - 350, image.getHeight() - 60);
            setImage(image);
            movin = 1;
            movinRight = 1;
            movinUp = 0;
            movinDown = 0;
            movinLeft = 0;
            //change image to Engine On, else Engine Off
        }
        if ( Greenfoot.isKeyDown("left") | Greenfoot.isKeyDown("a") )
        {
            setLocation(getX() + 2, getY());
            setImage("Ship Engine Off.png");
            GreenfootImage image = getImage();
            //image.scale(image.getWidth() - 260, image.getHeight() - 53);
            setImage(image);
            movinLeft = 1;
            movinUp = 0;
            movinDown = 0;
            movinRight = 0;
        }
        if ( Greenfoot.isKeyDown("Up") | Greenfoot.isKeyDown("w") )
        {
            setLocation(getX(), getY() + 2);
            movin = 1;
            movinUp = 1;
            movinLeft = 0;
            movinDown = 0;
            movinRight = 0;
        }
        if ( Greenfoot.isKeyDown("Down") | Greenfoot.isKeyDown("s") )
        {
            setLocation(getX(), getY() - 2);
            movin = 1;
            movinDown = 1;
            movinUp = 0;
            movinLeft = 0;
            movinRight = 0;
        }
        if (movin == 0) {
            setImage("Ship Engine Off.png");
            GreenfootImage image = getImage();
            //image.scale(image.getWidth() - 260, image.getHeight() - 53);
            setImage(image);
            setLocation(getX(), getY() - 2);

        }
        movin = 0;
        if(tillDeath <= 0)
        {
            //getWorld().addObject(new Text(), getX(), getY());
            Actor player = (Actor1) getWorld().getObjects(Actor1.class).get(0);  
            turnTowards(player.getX() + 100, player.getY());  

            move(15);
            Actor fastasteroid = getOneIntersectingObject(fastAsteroid.class);
            if(fastasteroid != null){
                go = 4;
                getWorld().addObject(new Explosion(), getX(), getY());
                getWorld().removeObject(fastasteroid);
                
                getWorld().removeObject(this);

            }
        }
    }

    public void npcshoot()
    {
        if (delay == 0) {
            getWorld().addObject(new Bullet(), getX() + 50, getY());

            delay = 20;

        }
        if (delay > 0) {
            delay --;
        }
        tillDeath --;
    }

    public void tutorial()
    {

        getWorld().addObject(new Text(), getX() + 200, getY());

    }
}
