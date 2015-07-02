import greenfoot.*;

/**
 * Write a description of class tutorialWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class tutorialWorld extends World
{

    /**
     * Constructor for objects of class tutorialWorld.
     * 
     */
    public tutorialWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1008, 800, 1); 

        prepare();
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        Actor1 actor1 = new Actor1();
        addObject(actor1, 323, 378);
        NPC npc = new NPC();
        addObject(npc, 264, 453);
        npc.setLocation(246, 328);
    }
}
