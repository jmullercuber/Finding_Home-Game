import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

import java.util.*;

/**
 * An explosion. It starts by expanding and then collapsing. 
 * The explosion will explode other obejcts that the explosion intersects.
 * 
 * @author Poul Henriksen
 * @version 1.0.1
 */
public class Explosion extends Actor
{
    /** How many images should be used in the animation of the explostion */
    private final static int IMAGE_COUNT= 60;
    
    /** 
     * The images in the explosion. This is static so the images are not
     * recreated for every object (improves performance significantly).
     */
    private static GreenfootImage[] images;
    
    /** Current size of the explosion */
    private int imageNo = 0;
    
    /** How much do we increment the index in the explosion animation. */
    private int increment=1;    
    
    public Explosion() {
        initialiseImages();
        setImage(images[0]);        
        
    }    
    
    /** 
     * Create the images for explosion.
     */
    public synchronized static void initialiseImages() {
        if(images == null) {
            GreenfootImage baseImage = new GreenfootImage("ledakan_2.png");
            images = new GreenfootImage[IMAGE_COUNT];
            for(int i=0; i < IMAGE_COUNT; i++) {
                int size = (i+1) * (baseImage.getWidth()/ IMAGE_COUNT);
                images[i] = new GreenfootImage(baseImage);
                images[i].scale(size, size);
            }
        }
    }
    
    /**
     * EXPLODE!
     */
    public void act()
    { 
        setImage(images[imageNo]);

        imageNo += increment;
        if(imageNo >= IMAGE_COUNT) {
            increment = -increment;
            imageNo += increment;
        }
        
        if(imageNo < 0) {
            getWorld().removeObject(this);
        }
    }
}