import greenfoot.*;

/**
 * Write a description of class playButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class playButton extends Button
{
    //GreenfootSound sound;

    GreenfootSound sound = new GreenfootSound("1.wav");
    int mute = 0;
    // Constructor
    public playButton() {
        // continuously play the start screen music

        //sound.playLoop();
    }

    public void act()
    {
        super.act();
        if (mute == 0){
            sound.play();
        }
        if(Greenfoot.isKeyDown("m")){
            mute = 1;
            sound.stop();

        }
    }
    public void onClick()
    {
        //tutorial not ready yet
        //Greenfoot.setWorld(new tutorialWorld());
        Greenfoot.setWorld(new tutorialWorld());
        sound.stop();
    }
}
