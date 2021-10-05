package com.mz.bear.scenes;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class WelcomeScene extends GeneralScene{

    public WelcomeScene(){
        super();
        showWelcomeMessage();
    }

    private void showWelcomeMessage(){
        Font myFont = Font.font("Arial", FontWeight.NORMAL, 32);
        gc.setFont(myFont);
        gc.setFill(Color.GREEN);
        gc.fillText("THE GAME", 275, 200);

        myFont = Font.font("Arial",FontWeight.NORMAL,20);
        gc.setFont(myFont);
        gc.setFill(Color.BROWN);
        gc.fillText("Press SPACE to start", 295,280 );



    }

    @Override
    public void draw() {
        showWelcomeMessage();
    }
}
