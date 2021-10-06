package com.mz.bear.scenes;

import com.mz.bear.GameBear;
import com.mz.bear.sprites.Player;
import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GameScene extends GeneralScene{

    private static final String BACKGROUND_IMAGE = "background.png";

    private Image background;
    private Player bear;
    public GameScene(){
        super();
//        background = new Image(BACKGROUND_IMAGE);

            background = new Image(BACKGROUND_IMAGE);
            bear = new Player();

    }

//    private void showGameMessage(){
//        Font myFont = Font.font("Arial", FontWeight.NORMAL, 24);
//        gc.setFont(myFont);
//        gc.setFill(Color.YELLOW);
//        gc.fillText("Game Scene", 325,200);
//    }

    @Override
    public void draw() {
        activeKeys.clear();
        bear.moveTo(380, 375);
        new AnimationTimer() {
            @Override
            public void handle(long currentNanoTime) {
                gc.setFill(Color.BLACK);
                gc.fillRect(0,0,GAME_WIDTH, GAME_HEIGH);

//                showGameMessage();
                gc.drawImage(background,0,0,GAME_WIDTH,GAME_HEIGH);
                bear.draw(gc);

                if (activeKeys.contains(KeyCode.ESCAPE)){
                    this.stop();
                    GameBear.setScene(GameBear.WELCOME_SCENE);
                } else if(activeKeys.contains(KeyCode.ENTER)){
                    this.stop();
                    GameBear.setScene(GameBear.GAME_OVER_SCENE);
                } else if(activeKeys.contains(KeyCode.LEFT)){
                    bear.move(Player.LEFT);
                } else if (activeKeys.contains((KeyCode.RIGHT))){
                    bear.move(Player.RIGHT);
                }
            }
        }.start();

    }
}
