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
        super(1008, 800, 1);


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
        playButton playbutton = new playButton();
        addObject(playbutton, 531, 306);
        playbutton.setLocation(524, 298);

        NPC npc = new NPC();
        addObject(npc, 305, 441);
        npc.setLocation(270, 429);
        creditsButton creditsbutton = new creditsButton();
        addObject(creditsbutton, 533, 401);
        creditsbutton.setLocation(526, 395);
    }
}
