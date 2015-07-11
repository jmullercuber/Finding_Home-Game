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
    int a = 0;

    
    /**
     * Act - do whatever the NPC wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        

            
        
        npcshoot();
        movement();
        drift();
        engineStatus();
        Actor asteroid = getOneIntersectingObject(Asteroid.class);
        if(asteroid != null){
            getWorld().addObject(new Explosion(), getX(), getY());
            getWorld().removeObject(this);
        }
        if(a == 0) {
            getWorld().addObject(new Text(), getX(), getY() - 15);
            a = 1;
        }
    }    

    public NPC()
    {
       
        
        bulletDelay = 10;
        
    }

    /**
     * The NPC ship needs to be able to move on its own according to where the asteroids are around it
     * Basically it can't move randomllu, it has to be somewhat smart about it.
     */
    
       
    

    public void npcshoot()
    {
        if (bulletDelay == 0) {
            getWorld().addObject(new Bullet(), getX() + 50, getY());

            bulletDelay = Greenfoot.getRandomNumber(200);

        }
        if (bulletDelay > 0) {
            bulletDelay --;
        }

    }

    
}
