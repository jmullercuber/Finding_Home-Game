import greenfoot.*;
import java.awt.Color;

/**
 * Write a description of class Text here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Text extends NPC
{
    
    public int untillDeath = 750;
    /**
     * Act - do whatever the Text wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {

        if(go == 0){
            sayAsteroids();
        }
        else if(go == 1) {
            sayToShoot();
            setImage(new GreenfootImage(".", 1, Color.BLACK, Color.BLACK));
        }
        if(go == 3) {
            sayWatchOut();
        }
        if(go == 4) {
            sayInvasion();
        }

    }

    public void sayWatchOut()
    {
        untillDeath = untillDeath - 1;

        if(untillDeath <= 0){
            setImage(new GreenfootImage("WATCH OUT!!!", 32, Color.WHITE, Color.BLACK));
            Greenfoot.delay(100);
            sayInvasion();
            
            //go = 4;
        }

    }
    public void sayInvasion()
    {
        
            setImage(new GreenfootImage("Tell them the enemy fleet bdslhbfa", 21, Color.WHITE, Color.BLACK));
            Greenfoot.delay(100);
            

            getWorld().removeObject(this);
        

    }

    public void sayAsteroids()
    {
        setImage(new GreenfootImage("Asteroid field ahead! Get ready!", 21, Color.WHITE, Color.BLACK));
        Greenfoot.delay(200);
        setImage(new GreenfootImage("Use the arrow keys or WASD keys to move", 50, Color.WHITE, Color.BLACK));
        Greenfoot.delay(400);
        go = 1;
    }

    public void sayToShoot()
    {
        setImage(new GreenfootImage("To shoot, hit spacebar", 50, Color.WHITE, Color.BLACK));
        Greenfoot.delay(350);
        setImage(new GreenfootImage("3", 21, Color.WHITE, Color.BLACK));
        Greenfoot.delay(65);
        setImage(new GreenfootImage("2", 21, Color.YELLOW, Color.BLACK));
        Greenfoot.delay(65);
        setImage(new GreenfootImage("1", 21, Color.RED, Color.BLACK));
        Greenfoot.delay(70);

        
        go = 3;

    }
}
