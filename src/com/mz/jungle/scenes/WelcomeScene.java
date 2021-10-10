package com.mz.jungle.scenes;

import com.mz.bear.GameBear;
import com.mz.jungle.Game;
import javafx.animation.AnimationTimer;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.EventListener;

public class WelcomeScene extends GeneralScene {

    public WelcomeScene(){
        super();
        showWelcomeMessage();
    }


    private void showWelcomeMessage() {
        Font myFont = Font.font("Arial", FontWeight.NORMAL, 32);
        gc.setFont(myFont);
        gc.setFill(Color.GREEN);
        gc.fillText("WELCOME SCENE", 270, 240);

        myFont = Font.font("Arial", FontWeight.NORMAL, 20);
        gc.setFont(myFont);
        gc.setFill(Color.WHITE);
        gc.fillText("Press space to start the game", 280, 340);
    }

    @Override
    public void draw() {
        activeKeys.clear();

        new AnimationTimer() {
            @Override
            public void handle(long now) {
                gc.setFill(Color.BLACK);
                gc.fillRect(0,0,GAME_WIDTH,GAME_HEIGHT);

                showWelcomeMessage();
                if(activeKeys.contains(KeyCode.SPACE)){
                    this.stop();
                    Game.setScene(Game.GAME_SCENE);
                } else if (activeKeys.contains(KeyCode.ESCAPE))
                {
                    this.stop();
                    Game.exit();
                }
            }
        }.start();

    }
}
