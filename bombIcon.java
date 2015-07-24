import greenfoot.*;

/**
 * Write a description of class BombIcon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class bombIcon extends PowerUps
{
    public bombIcon() {
        super(-2);
        setImage("Ship Engine Off.png");
    }
    
    public void touched()
    {
        if( ((Play)getWorld()).player.timer <= 1000) {
            Actor player = getOneIntersectingObject(Actor1.class);
            if (player != null) {
                getWorld().addObject(new bombText(),getX(), getY() );
                Greenfoot.delay(10);
                getWorld().removeObject(this);
            }
        }
    }
}
