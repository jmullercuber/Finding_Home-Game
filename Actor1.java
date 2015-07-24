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
    private int movingUp = 0;
    private int movingDown = 0;
    private int movingRight = 0;
    private int movingLeft = 0;
    //music timer.
    public int timer = 0;
    public int asteroidDelay = 1;
    //Rate of creating new asteroid. The lower int difficulty, the higher the rate of new asteroids.
    int difficulty = 10;
    //The chance of a new NPC being created.
    private int chance;
    //Whether or not mute is on or not. mute off = 0, mute on = 1.
    private int mute = 0;
    //Souns for background music
    GreenfootSound sound = new GreenfootSound("1.wav");

    GreenfootSound sound4 = new GreenfootSound("4.wav");
    int bomb = 0;
    int bombChance = 1;

    /**
     * Act - do whatever the Actor1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        activateBomb();

        movement();

        spawnBomb();

        shoot();

        drift();

        muteFunction();

        createAsteroid();

        populateNPC();

        //lose();

        engineStatus();

        timer = timer + 1;
        if(timer == 36590) {
            sound4.play();
        }
        radioTrans();

    }

    private void radioTrans()
    {
        if(timer == 15000){
            getWorld().addObject(new Radio(), 1008, 400);
        }
        if(timer == 23000){  
                getWorld().addObject(new Patrol(), 1008, 400);
            }
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

            sound4.stop();
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
        timer = timer + 1;
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
            movingRight = 1;
            movingUp = 0;
            movingDown = 0;
            movingLeft = 0;
            //change image to Engine On, else Engine Off
        }
        else if ( (Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("a")) && !(Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d")) )
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
        if ( (Greenfoot.isKeyDown("up") || Greenfoot.isKeyDown("w")) && !(Greenfoot.isKeyDown("down") || Greenfoot.isKeyDown("s")) )
        {
            setLocation(getX(), getY() - 2);
            moving = 1;
            movingUp = 1;
            movingLeft = 0;
            movingDown = 0;
            movingRight = 0;
        }
        else if ( (Greenfoot.isKeyDown("down") || Greenfoot.isKeyDown("s")) && !(Greenfoot.isKeyDown("up") || Greenfoot.isKeyDown("w")) )
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

    public void activateBomb()
    {
        Actor haveBomb = getOneIntersectingObject(bombIcon.class);
        if(haveBomb != null){
            bomb = bomb + 1;
            if(timer <= 1000) {
                getWorld().addObject(new bombText(),getX(), getY() +50 );

            }
            getWorld().removeObject(haveBomb);
        }
        if(bomb >= 1)
        {
            if(Greenfoot.isKeyDown("Q") || Greenfoot.isKeyDown("E"))
            {
                bomb = bomb - 1;
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

    public void spawnBomb()
    {
        if(bombChance == 1)
        {
            getWorld().addObject(new bombIcon(), 1008, Greenfoot.getRandomNumber(850));
        }
        bombChance = Greenfoot.getRandomNumber(1200);
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
