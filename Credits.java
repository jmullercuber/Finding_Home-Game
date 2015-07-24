import greenfoot.*;

/**
 * Write a description of class credits here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Credits extends World
{
    public static Credits credits = new Credits();
    
    /**
     * Constructor for objects of class credits.
     * Only ever need one Credits object, so private constructor
     * Access via static instance
     * 
     */
    private Credits()
    {
        // Create a new world with 1008x630 cells with a cell size of 1x1 pixels.
        super(1008, 630, 1);
        this.setBackground("Credits Screen Finding Home.png");
        
        // backButton
        addObject(new backButton(), 110, 80);
    }
}
