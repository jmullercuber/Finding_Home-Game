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
        playAgainButton playagainbutton = new playAgainButton();
        addObject(playagainbutton, 486, 673);
        playagainbutton.setLocation(482, 668);
    }
}
