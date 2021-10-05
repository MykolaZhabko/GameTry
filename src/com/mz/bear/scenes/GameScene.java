package com.mz.bear.scenes;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class GameScene extends GeneralScene{

    public GameScene(){
        super();
    }

    private void showGameMessage(){
        Font myFont = Font.font("Arial", FontWeight.NORMAL, 24);
        gc.setFont(myFont);
        gc.setFill(Color.YELLOW);
        gc.fillText("Game Scene", 325,200);




    }

    @Override
    public void draw() {
        showGameMessage();
    }
}
