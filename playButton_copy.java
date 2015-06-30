import greenfoot.*;

/**
 * Write a description of class playButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class playButton extends Actor
{
   GreenfootSound sound = new GreenfootSound("1.wav");
    /**
     * Act - do whatever the playButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        sound.play();
        if(Greenfoot.mouseClicked(this)){
            Greenfoot.setWorld(new play());
            sound.stop();
        }
    }    
}
