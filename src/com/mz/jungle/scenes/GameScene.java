package com.mz.jungle.scenes;

import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class GameScene extends GeneralScene{
    private static final String BACKGROUND_IMAGE = "bg_forest.png";

    private Image background;
    private Image[] forestImages;

    public GameScene(){
        super();
        background = new Image(BACKGROUND_IMAGE);
        forestImages = new Image[2];
        forestImages[0] = new Image("forest/forest_pack_13.png",64,64,true,true);

    }

    @Override
    public void draw() {
        activeKeys.clear();
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                gc.setFill(Color.BLACK);
                gc.fillRect(0,0, GAME_WIDTH, GAME_HEIGHT);
                gc.drawImage(background,0,0,GAME_WIDTH,GAME_HEIGHT);

                gc.drawImage(forestImages[0], 200,200);

                if (activeKeys.contains(KeyCode.SPACE)){
                    System.out.println("Tile height = " + forestImages[0].getHeight());
                    System.out.println("Tile width = " + forestImages[0].getWidth());

                }
            }
        }.start();

    }


}
