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
    protected int delay = 0;
    private int moving = 0;
    private int movingUp = 0;
    private int movingDown = 0;
    private int movingRight = 0;
    private int movingLeft = 0;
    public int timer = 0;
    public int asteroidDelay = 1;
    int difficulty = 20;
    int a = 20;
    private int mute = 0;
    GreenfootSound sound = new GreenfootSound("1.wav");
    GreenfootSound sound2 = new GreenfootSound("2.wav");
    GreenfootSound sound3 = new GreenfootSound("3.wav");
    GreenfootSound sound4 = new GreenfootSound("4.wav");
    GreenfootSound sound5 = new GreenfootSound("5.wav");
    GreenfootSound sound6 = new GreenfootSound("6.wav");
    /**
     * Act - do whatever the Actor1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        movement();
        shoot();
        drift();
        createAsteroid();
        if(mute == 0) {
              playSongs();
        }
        if(Greenfoot.isKeyDown("m")){
            mute = 1;
            sound.stop();
            sound2.stop();
            sound3.stop();
            sound4.stop();
            sound5.stop();
        }
        
        
        //Turn back on
        //lose();
    }

    public void playSongs()
    {
        if(timer == 0)  {
            sound2.play();
        }
        timer ++;

        if(timer == 7830) {
            sound3.play();
        }
        if(timer == 38510) {
            sound4.play();
        }
        if(timer == 41226) {
            sound5.play();
        }
        if(timer == 44277) {
            sound6.play();
        }

    }

    public void lose()
    {
        Actor asteroid = getOneIntersectingObject(Asteroid.class);
        if(asteroid != null){
            sound.stop();
            sound2.stop();
            sound3.stop();
            sound4.stop();
            sound5.stop();
            Greenfoot.setWorld(new lose());
        }
        Actor turningasteroid = getOneIntersectingObject(turningAsteroid.class);
        if(turningasteroid != null){
            sound.stop();
            Greenfoot.setWorld(new lose());
        }
    }

    public void movement()
    {
        if ( Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d") )
        {
            setLocation(getX() + 2, getY());
            setImage("Ship Engine On.png");
            GreenfootImage image = getImage();
            //image.scale(image.getWidth() - 350, image.getHeight() - 60);
            setImage(image);
            moving = 1;
            movingRight = 1;
            movingUp = 0;
            movingDown = 0;
            movingLeft = 0;
            //change image to Engine On, else Engine Off
        }
        if ( Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("a") )
        {
            setLocation(getX() - 2, getY());
            setImage("Ship Engine Off.png");
            GreenfootImage image = getImage();
            //image.scale(image.getWidth() - 260, image.getHeight() - 53);
            setImage(image);
            movingLeft = 1;
            movingUp = 0;
            movingDown = 0;
            movingRight = 0;
        }
        if ( Greenfoot.isKeyDown("up") || Greenfoot.isKeyDown("w") )
        {
            setLocation(getX(), getY() - 2);
            moving = 1;
            movingUp = 1;
            movingLeft = 0;
            movingDown = 0;
            movingRight = 0;
        }
        if ( Greenfoot.isKeyDown("down") || Greenfoot.isKeyDown("s") )
        {
            setLocation(getX(), getY() + 2);
            moving = 1;
            movingDown = 1;
            movingUp = 0;
            movingLeft = 0;
            movingRight = 0;
        }
        if (moving == 0) {
            setImage("Ship Engine Off.png");
            GreenfootImage image = getImage();
            //image.scale(image.getWidth() - 260, image.getHeight() - 53);
            setImage(image);

        }
        moving = 0;
    }

    public void shoot()
    {
        if (delay == 0) {
            if (Greenfoot.isKeyDown("space")) {
                getWorld().addObject(new Bullet(), getX() + 50, getY());

                delay = 20;
            }
        }
        if (delay > 0) {
            delay --;
        }
    }

    

    public void drift()
    {
        if (movingUp == 1) {
            setLocation(getX(), getY() - 1);
        }
        if (movingDown == 1) {
            setLocation(getX(), getY() + 1);
        }
        if (movingRight == 1) {
            setLocation(getX() + 1, getY());
        }
        if (movingLeft == 1) {
            setLocation(getX() - 1, getY());
        }
    }

    public void createAsteroid()
    {
        if(asteroidDelay > 0){
            asteroidDelay--;
            if (asteroidDelay == 0) {
                populate();
                asteroidDelay = difficulty;
            }
        }
    }    

    public void populate()
    {
        getWorld().addObject(new Asteroid(), 1008, Greenfoot.getRandomNumber(850));
    }
}
