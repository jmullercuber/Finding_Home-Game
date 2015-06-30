import greenfoot.*;

/**
 * Write a description of class play here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Play extends World
{
    public static Play play = new Play();
    public int timer = 0;
    /**
     * Constructor for objects of class play.
     * 
     */
    public Play()
    {
        super(1008, 800, 1);
        addObject(new Asteroid(), 1500, Greenfoot.getRandomNumber(400));
        addObject(new Actor1(), 50, 400);
        Greenfoot.playSound("2.wav");
        addObject(new Counter(), 189, 38);
    }
    
    public void act()
    {
        timer ++;
        if (timer == 7830) {
            Greenfoot.playSound("3.wav");
        }
        else if (timer == 38410) {
            Greenfoot.playSound("4.wav");
        }
        else if (timer == 39826) {
            Greenfoot.playSound("5.wav");
        }
        else if (timer == 43177) {
            Greenfoot.playSound("6.wav");
        }
    }
}
