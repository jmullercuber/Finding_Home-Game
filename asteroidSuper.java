import greenfoot.*;

/**
 * Write a description of class asteroidSuper here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class asteroidSuper extends Actor
{
    public int asteroidDelay = 100;
    public int asteroidSpeed = 3;
    private int number = 0;
    private int turning = 0;
    public int a = 0;
    public int rotateSpeed = 39090;
    public int timer = 0;
    /**
     * Act - do whatever the asteroidSuper wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if( timer == 25000) {
            asteroidSpeed = 4;
        }
        if( timer == 15000) {
            asteroidSpeed = 5;
        }
        if( timer == 5000) {
            asteroidSpeed = 6;
        }
        timer = timer - 1;
    }    
}
