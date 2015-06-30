import greenfoot.*;

/**
 * Write a description of class Actor1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Actor1 extends Actor
{
    public int health = 3;
    private int delay = 0;
    private int moving = 0;
    private int movingUp = 0;
    private int movingDown = 0;
    private int movingRight = 0;
    private int movingLeft = 0;
    /**
     * Act - do whatever the Actor1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        movement();
        shoot();
        drift();
    }

    public void movement()
    {
        if( Greenfoot.isKeyDown("right"))
        {
            setLocation(getX() + 2, getY());
            setImage("Ship Engine On.png");
            GreenfootImage image = getImage();
            image.scale(image.getWidth() - 350, image.getHeight() - 60);
            setImage(image);
            moving = 1;
            movingRight = 1;
            movingUp = 0;
            movingDown = 0;
            movingLeft = 0;
            //change image to Engine On, else Engine Off
        }
        if( Greenfoot.isKeyDown("left"))
        {
            setLocation(getX() - 2, getY());
            setImage("Ship Engine Off.png");
            GreenfootImage image = getImage();
            image.scale(image.getWidth() - 260, image.getHeight() - 53);
            setImage(image);
            movingLeft = 1;
            movingUp = 0;
            movingDown = 0;
            movingRight = 0;
        }
        if( Greenfoot.isKeyDown("Up"))
        {
            setLocation(getX(), getY() - 2);
            moving = 1;
            movingUp = 1;
            movingLeft = 0;
            movingDown = 0;
            movingRight = 0;
        }
        if(Greenfoot.isKeyDown("Down"))
        {
            setLocation(getX(), getY() + 2);
            moving = 1;
            movingDown = 1;
            movingUp = 0;
            movingLeft = 0;
            movingRight = 0;
        }
        if( Greenfoot.isKeyDown("d"))
        {
            setLocation(getX() + 2, getY());
            setImage("Ship Engine On.png");
            GreenfootImage image = getImage();
            image.scale(image.getWidth() - 350, image.getHeight() - 60);
            setImage(image);
            moving = 1;
            movingRight = 1;
            movingUp = 0;
            movingDown = 0;
            movingLeft = 0;
        }
        if( Greenfoot.isKeyDown("a"))
        {
            setLocation(getX() - 2, getY());
            setImage("Ship Engine Off.png");
            GreenfootImage image = getImage();
            image.scale(image.getWidth() - 260, image.getHeight() - 53);
            setImage(image);
            movingLeft = 1;
            movingUp = 0;
            movingDown = 0;
            movingRight = 0;
        }
        if( Greenfoot.isKeyDown("w"))
        {
            setLocation(getX(), getY() - 2);
            moving = 1;
            movingUp = 1;
            movingDown = 0;
            movingLeft = 0;
            movingRight = 0;
        }
        if(Greenfoot.isKeyDown("s"))
        {
            setLocation(getX(), getY() + 2);
            moving = 1;
            movingDown = 1;
            movingUp = 0;
            movingLeft = 0;
            movingRight = 0;
        }
        if(moving == 0) {
            setImage("Ship Engine Off.png");
            GreenfootImage image = getImage();
            image.scale(image.getWidth() - 260, image.getHeight() - 53);
            setImage(image);

        }
        moving = 0;
    }

    public void shoot()
    {
        if(delay == 0) {
            if(Greenfoot.isKeyDown("space")) {
                getWorld().addObject(new Bullet(), getX() + 50, getY());

                delay = 20;
            }

        }
        if(delay > 0) {
            delay --;
        }
    }

    public void drift()
    {
        if(movingUp == 1) {
            setLocation(getX(), getY() - 1);

        }
        if(movingDown == 1) {
            setLocation(getX(), getY() + 1);
        }
        if(movingRight == 1) {
            setLocation(getX() + 1, getY());
        }
        if(movingLeft == 1) {
            setLocation(getX() - 1, getY());
        }
    }

    public void npcshoot()
    {
        if(delay == 0) {

            getWorld().addObject(new Bullet(), getX() + 50, getY());

            delay = 20;

        }
        if(delay > 0) {
            delay --;
        }
    }

}
