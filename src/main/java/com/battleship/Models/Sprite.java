package com.battleship.Models;

import javafx.scene.image.Image;

public class Sprite {
    public Image TopImage;
    public Image BottomImage; 
    public boolean RotateBottomWithTop; 

    /**
     * Creates a new Sprite object
     * @param TopImage The image to be stacked on the top. make NULL if 1 layer sprite
     * @param BottomImage The image for the bottom, never NULL
     * @param RotateBottomWithTop Whether the bottom image needs to be rotated with the top. Default FALSE
     */
    public Sprite(Image TopImage, Image BottomImage, boolean RotateBottomWithTop)
    {
        this.TopImage = TopImage;
        this.BottomImage = BottomImage; 
        this.RotateBottomWithTop = RotateBottomWithTop; 
    }

    /**
     * Creates a new Sprite object
     * @param TopImage The image to be stacked on the top. make NULL if 1 layer sprite
     * @param BottomImage The image for the bottom, never NULL
     */
    public Sprite(Image TopImage, Image BottomImage)
    {
        this.TopImage = TopImage;
        this.BottomImage = BottomImage; 
        RotateBottomWithTop = false; 
    }
}
