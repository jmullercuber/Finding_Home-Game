import greenfoot.*;

/**
 * Write a description of class Win here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Win extends World
{
    GreenfootSound sound7 = new GreenfootSound("7.wav");
    /**
     * Constructor for objects of class Win.
     * 
     */
    public Win()
    {   
        super(600, 400, 1); 
        sound7.play();
        prepare();
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        Actor powerups = new NPC();
        addObject(powerups, 241, 252);
        Actor powerups2 = new NPC();
        addObject(powerups2, 189, 298);
    }
}
