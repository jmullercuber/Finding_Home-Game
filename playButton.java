import greenfoot.*;

/**
 * Write a description of class playButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class playButton extends Button
{
    GreenfootSound sound;
    
    // Constructor
    public playButton() {
        // continuously play the start screen music
        this.sound = new GreenfootSound("1.wav");
        sound.playLoop();
    }
    
    public void onClick()
    {
        Greenfoot.setWorld(new play());
        sound.stop();
    }
}
