/**
 * A sprite is a multilayered image. 
 * 
 * Allows for 3 images to be stacked at once, and loaded into memory for quick recall. 
 */

package com.battleship.Models;

import javafx.scene.image.Image;

public class Sprite {
    // all sprites are at least the bottom image which will be the ocean tile
    // middle images are usually sprites like boats
    // top images will be sprites like flames for getting hit
    public Image TopImage;
    public Image MiddleImage; 
    public Image BottomImage; 
    public boolean isOverlay; // if true, then sprite will be an overlay which will ignore bottom and middle layers

    /**
     * Creates a new Sprite object. TopImage and MiddleImage are set to NULL.
     * @param BottomImage The image on the bottom layer. 
     */
    public Sprite(Image bottomImage)
    {
        // this should be for ocean tiles without ships or anything else
        this.TopImage = null;
        this.MiddleImage = null; 
        this.BottomImage = bottomImage; 
        isOverlay = false; 
    }

    /**
     * Creates a new Sprite object. TopImage is set to NULL.
     * @param bottomImage The image on the bottom layer. 
     * @param middleImage The image on the middle layer.
     */
    public Sprite(Image bottomImage, Image middleImage)
    {
        // ocean tile + something like ships or flags
        this.TopImage = null;
        this.MiddleImage = middleImage; 
        this.BottomImage = bottomImage; 
        isOverlay = false; 
    }

    /**
     * Creates a new Sprite object.
     * @param bottomImage The image on the bottom layer. 
     * @param middleImage The image on the middle layer.
     * @param topImage The image on the top layer.
     */
    public Sprite(Image bottomImage, Image middleImage, Image topImage)
    {
        // ocean tile + ship + hit
        this.TopImage = topImage;
        this.MiddleImage = middleImage;
        this.BottomImage = bottomImage; 
        isOverlay = false; 
    }

    /**
     * Creates a new Sprite Overlay
     * @param topImage The image to overlay
     * @param isOverlay Sets the sprite to overlay on top of another sprite
     */
    public Sprite(Image topImage, boolean isOverlay)
    {
        this.TopImage = topImage;
        this.MiddleImage = null;
        this.BottomImage = null; 
        isOverlay = false; 
    }
}
