package com.mz.bear.scenes;

import com.mz.bear.GameBear;
import javafx.animation.AnimationTimer;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class GameOverScene extends GeneralScene{

    public GameOverScene(){
        super();
    }

    public void showGameOverMessage(){
        Font myFont = Font.font("Arial", FontWeight.NORMAL, 25);
        gc.setFont(myFont);
        gc.setFill(Color.GREEN);
        gc.fillText("Game Over", 200,200);

        myFont = Font.font("Arial", FontWeight.NORMAL, 15);
        gc.setFont(myFont);
        gc.setFill(Color.GREEN);
        gc.fillText("Press SPACE to go to Welcome page", 200,250);


    }

    @Override
    public void draw() {
        activeKeys.clear();
        new AnimationTimer() {
            @Override
            public void handle(long currentNanoTime) {
                gc.setFill(Color.BLACK);
                gc.fillRect(0,0,GAME_WIDTH, GAME_HEIGH);

                showGameOverMessage();

                if (activeKeys.contains(KeyCode.SPACE)){
                    this.stop();
                    GameBear.setScene(GameBear.WELCOME_SCENE);
                } else if(activeKeys.contains(KeyCode.ESCAPE)){
                    this.stop();
                    GameBear.exit();
                }
            }
        }.start();

    }
}
