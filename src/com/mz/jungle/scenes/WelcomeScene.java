package com.mz.jungle.scenes;

import javafx.animation.AnimationTimer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class WelcomeScene extends GeneralScene {

    public WelcomeScene(){
        super();
        showWelcomeMessage();
    }

    private void showWelcomeMessage() {
        Font myFont = Font.font("Arial", FontWeight.NORMAL, 32);
        gc.setFont(myFont);
        gc.setFill(Color.GREEN);
        gc.fillText("WELCOME SCENE", 350, 240);
    }

    @Override
    public void draw() {

        new AnimationTimer() {
            @Override
            public void handle(long now) {
                gc.setFill(Color.BLACK);
                gc.fillRect(0,0,GAME_WIDTH,GAME_HEIGHT);

            }
        }.start();

    }
}
