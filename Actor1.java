import greenfoot.*;

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
    private int movingUp = 0;
    private int movingDown = 0;
    private int movingRight = 0;
    private int movingLeft = 0;
    //music timer.
    public int timer = -0;
    public int asteroidDelay = 1;
   //Rate of creating new asteroid. The lower int difficulty, the higher the rate of new asteroids.
    int difficulty = 10;
    //The chance of a new NPC being created.
    private int chance;
    //Whether or not mute is on or not. mute off = 0, mute on = 1.
    private int mute = 0;
    //Souns for background music
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
        
        muteFunction();

        createAsteroid();

        populateNPC();

        lose();
        
        engineStatus();
    }

    /**
     * Allows the player to mute the current music playing if key m is pressed.
     */
    public void muteFunction()
    {
        if(mute == 0)  
        {

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
    }
    public Actor1()
    {
        
    }
    /**
     * Plays the continuous background music.
     * Runs on hard timer, int timer. timer ++ included here.
     */
    public void playSongs()
    {
        if(timer == 0)  {
            getWorld().addObject(new NPC(),getX() - Greenfoot.getRandomNumber(200) , getY() + Greenfoot.getRandomNumber(100) );
            sound3.play();

        }
        timer ++;
        if(timer == 31080) {
            sound4.play();
        }
        if(timer == 33396) {
            sound5.play();
        }
        if(timer == 41226) {
            //sound6.play();
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
            sound2.stop();
            sound3.stop();
            sound4.stop();
            sound5.stop();
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
     * Allows the player to use the arrow keys to move the ship.
     * Changes the ship image depending on direction the ship is moving.
     */
    public void movement()
    {
        if ( Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d") )
        {
            setLocation(getX() + 2, getY());
            //setImage("Ship Engine On.png");
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
            //setImage("Ship Engine Off.png");
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
            //setImage("Ship Engine Off.png");
            GreenfootImage image = getImage();
            //image.scale(image.getWidth() - 260, image.getHeight() - 53);
            setImage(image);

        }
        moving = 0;
    }

    /**
     * If spacebar is pressed, new bullet is created and a delay is added for when the next bullet may be shot.
     * Rapidfire powerup code.
     */
    public void shoot()
    {
        Actor rapidfire = getOneIntersectingObject(rapidFireIcon.class);
        if (bulletDelay == 0) {
            if (Greenfoot.isKeyDown("space")) {
                getWorld().addObject(new Bullet(), getX() + 50, getY());
                if(rapidfire != null){
                    bulletDelay = 10;
                }
                else if (rapidfire == null)
                {
                    bulletDelay = 100;
                }
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

    /** 
     * Decides when to create asteroids. Rate of creation dependent on int difficulty.
     */
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

    /**
     * Creates new asteroid at random Y location.
     */
    public void populate()
    {
        getWorld().addObject(new Asteroid(), 1008, Greenfoot.getRandomNumber(850));
    }

    /**
     * Creates new NPC/ Probability of new NPC.
     */
    public void populateNPC()
    {
        chance = Greenfoot.getRandomNumber(10000);
        if( chance == 1 ){
            getWorld().addObject(new NPC(),getX() - Greenfoot.getRandomNumber(200) , getY() + Greenfoot.getRandomNumber(100) );
        }

    }
}
