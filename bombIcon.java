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
        Actor obj = getOneIntersectingObject(Actor1.class);
        if (obj != null) {
            Actor1 player = ((Actor1)obj);
            player.bomb += 1;
            if (player.timer <= 1000) { 
                getWorld().addObject(new bombText(), player.getX(), player.getY()+50 );
                getWorld().removeObject(this);
            }
        }
    }
}
