package com.mz.bear.sprites;

import javafx.scene.image.Image;

public class Player extends AnimatedSprite{

    public static final int PLAYER_WIDTH = 68;
    public static final int PLAYER_HEIGHT = 40;
    private static final String IMAGE_PATH = "bearSprite.png";
    public static final int LEFT = 0;
    public static final int RIGHT = 1;



    public Player() {
        super(PLAYER_WIDTH, PLAYER_HEIGHT);
        spriteImage = new Image(IMAGE_PATH);

        spriteXCoordinates[RIGHT] = new int[]{0, 68, 136,204,272,340,408,476};
        spriteYCoordinates[RIGHT] = new int[]{0, 0, 0, 0,0, 0, 0, 0};
        spriteXCoordinates[LEFT] = new int[]{1020, 952, 884, 816, 748, 680, 612,544};
        spriteYCoordinates[LEFT] = new int[]{0, 0, 0, 0,0, 0, 0, 0};

    }

    public void move(int movement){
        int newX = x;
        if (movement == LEFT){
            newX -= 1;
        }else if (movement == RIGHT){
            newX += 1;
        }
        moveTo(newX, y);
        animate(movement);
    }
}
