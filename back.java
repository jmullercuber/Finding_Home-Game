import greenfoot.*;

/**
 * Write a description of class back here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class back extends World
{
    public int asteroidDelay = 100;

    /**
     * Constructor for objects of class back.
     * 
     */
    public back()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1008, 630, 1);
        prepare();
    }
    
    public void act()
    {
        //Greenfoot.playSound("7 Main Theme.wav");
    }
    
    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        // populate the world with objects
        
        // playButton
        playButton playbutton = new playButton();
        addObject(playbutton, 531, 306);
        playbutton.setLocation(524, 298);
        
        // NPC
        //NPC npc = new NPC();
        //addObject(npc, 305, 441);
        //npc.setLocation(270, 429);
        
        // credits button
        creditsButton creditsbutton = new creditsButton();
        addObject(creditsbutton, 533, 401);
        creditsbutton.setLocation(526, 395);
    }
}
