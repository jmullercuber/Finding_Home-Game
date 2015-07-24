import greenfoot.*;
import java.awt.Color;
/**
 * Write a description of class Actor1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Actor1 extends Actor
{
    protected int bulletDelay = 0;
    //Denotes which direction the player is moving in.
    private int moving = 0;
    private boolean movingUp = false;
    private boolean movingDown = false;
    private boolean movingRight = false;
    private boolean movingLeft = false;
    //music timer.
    public int timer = 0;
    //Whether or not mute is on or not. mute off = false, mute on = true.
    private boolean mute = false;
    //Souns for background music
    GreenfootSound sound = new GreenfootSound("1.wav");

    GreenfootSound sound4 = new GreenfootSound("4.wav");
    int bomb = 0;

    /**
     * Act - do whatever the Actor1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        activateBomb();
        movement();
        shoot();
        drift();
        muteFunction();
        //lose();
        engineStatus();

        timer += 1;
        if(timer == 36590) {
            sound4.play();
        }
    }

    /**
     * Allows the player to mute the current music playing if key m is pressed.
     */
    public void muteFunction()
    {
        if (Greenfoot.isKeyDown("m")) {
            if (mute == true) {
                // crank the dial to the right
                playSongs();
            }
            else {  // mute is currently false
                // digging the quiet solitude
                sound.stop();
                sound4.stop();
            }
            // invert the value
            mute = !mute;
        }
    }

    public Actor1()
    {

    }

    /**
     * Plays the continuous background music.
     * Runs on hard timer, int timer. timer ++ included here.
     * Adds initial NPC
     */
    public void playSongs()
    {
        if(timer == 0)  {
            getWorld().addObject(new NPC(),getX() - Greenfoot.getRandomNumber(200) , getY() + Greenfoot.getRandomNumber(100) );
        }
        if(timer <= 30080) {
            sound.play();
        }
        if(timer == 30080) {
            sound.stop();
            sound4.play();
        }
    }

    /**
     * Switches to lose screen if the object intersects with an asteroid.
     */
    public void lose()
    {
        Actor asteroid = getOneIntersectingObject(Asteroid.class);

        if(asteroid != null){
            sound.stop();
            sound4.stop();
            Greenfoot.setWorld(new lose());
        }
    }

    public void engineStatus()
    {
        if ( Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d") )
        {
            setImage("Ship Engine On.png");
        }
        else
        {
            setImage("Ship Engine Off.png");
        }
    }

    /**
     * Allows the player to use the WASD/arrow keys to move the ship.
     * Changes the ship image depending on direction the ship is moving.
     */
    public void movement()
    {
        if ( (Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d")) && !(Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("a")) )
        {
            setLocation(getX() + 2, getY());
            //setImage("Ship Engine On.png");
            GreenfootImage image = getImage();
            //image.scale(image.getWidth() - 350, image.getHeight() - 60);
            setImage(image);
            moving = 1;
            movingRight = true;
            movingUp = movingDown = movingLeft = false;
            //change image to Engine On, else Engine Off
        }
        else if ( (Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("a")) && !(Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d")) )
        {
            setLocation(getX() - 2, getY());
            //setImage("Ship Engine Off.png");
            GreenfootImage image = getImage();
            //image.scale(image.getWidth() - 260, image.getHeight() - 53);
            setImage(image);
            movingLeft = true;
            movingUp = movingDown = movingRight = false;
        }
        if ( (Greenfoot.isKeyDown("up") || Greenfoot.isKeyDown("w")) && !(Greenfoot.isKeyDown("down") || Greenfoot.isKeyDown("s")) )
        {
            setLocation(getX(), getY() - 2);
            moving = 1;
            movingUp = true;
            movingLeft = movingDown = movingRight = false;
        }
        else if ( (Greenfoot.isKeyDown("down") || Greenfoot.isKeyDown("s")) && !(Greenfoot.isKeyDown("up") || Greenfoot.isKeyDown("w")) )
        {
            setLocation(getX(), getY() + 2);
            moving = 1;
            movingDown = true;
            movingUp = movingLeft = movingRight = false;
        }
        if (moving == 0) {
            //setImage("Ship Engine Off.png");
            GreenfootImage image = getImage();
            //image.scale(image.getWidth() - 260, image.getHeight() - 53);
            setImage(image);
        }
        moving = 0;
    }

    public void activateBomb()
    {
        if(bomb >= 1)
        {
            if(Greenfoot.isKeyDown("Q") || Greenfoot.isKeyDown("E"))
            {
                bomb -= 1;
                getWorld().addObject(new Explosion(), getX(), getY() - 50);
                getWorld().addObject(new Explosion(), getX() + 50, getY());
                getWorld().addObject(new Explosion(), getX() - 50, getY());
                getWorld().addObject(new Explosion(), getX(), getY() + 50);
                getWorld().addObject(new Explosion(), getX(), getY());
            }
        }
    }

    /**
     * If spacebar is pressed, new bullet is created and a delay is added for when the next bullet may be shot.
     * Rapidfire powerup code.
     */
    public void shoot()
    {
        if (bulletDelay == 0) {
            if (Greenfoot.isKeyDown("space")) {
                getWorld().addObject(new Bullet(), getX() + 50, getY());
                if(timer <= 200) {
                    getWorld().addObject(new actorText(), getX() + 100, getY());
                }
                bulletDelay = 60;
            }
        }
        if (bulletDelay > 0) {
            bulletDelay --;
        }
    }

    /**
     * Depending on the last direction of the player, the ship will continue to "drift" in that direction.
     */
    public void drift()
    {
        if (movingUp && !movingDown) {
            setLocation(getX(), getY() - 1);
        }
        else if (movingDown && !movingUp) {
            setLocation(getX(), getY() + 1);
        }
        else if (movingRight && !movingLeft) {
            setLocation(getX() + 1, getY());
        }
        else if (movingLeft && !movingRight) {
            setLocation(getX() - 1, getY());
        }
    }
}
