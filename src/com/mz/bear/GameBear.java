package com.mz.bear;

import com.mz.bear.scenes.GameOverScene;
import com.mz.bear.scenes.GameScene;
import com.mz.bear.scenes.GeneralScene;
import com.mz.bear.scenes.WelcomeScene;
import javafx.application.Application;
import javafx.stage.Stage;

public class GameBear extends Application {

    public static final int MAX_SCENES = 3;
    public static final int WELCOME_SCENE = 0;
    public static final int GAME_SCENE = 1;
    public static final int GAME_OVER_SCENE = 2;

    public static final GeneralScene[] scenes = new GeneralScene[MAX_SCENES];

    private static Stage stage;

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;

        scenes[0] = new WelcomeScene();
        scenes[1] = new GameScene();
        scenes[2] = new GameOverScene();

        stage.setTitle("GAME");
        setScene(WELCOME_SCENE);
        stage.show();
    }

    //method to swap from one scene to another
    public static void setScene(int numScene){
        stage.setScene(scenes[numScene]);
        scenes[numScene].draw();
    }

    public static void exit(){
        stage.hide();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
