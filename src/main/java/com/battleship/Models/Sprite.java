package com.battleship.Models;

import javafx.scene.image.Image;

public class Sprite {
    public Image TopImage;
    public Image MiddleImage; 
    public Image BottomImage; 
    public boolean isOverlay; 

    /**
     * Creates a new Sprite object. TopImage and MiddleImage are set to NULL.
     * @param BottomImage The image on the bottom layer. 
     */
    public Sprite(Image bottomImage)
    {
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
