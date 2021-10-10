package com.mz.jungle;

import com.mz.jungle.scenes.GameScene;
import com.mz.jungle.scenes.GeneralScene;
import com.mz.jungle.scenes.WelcomeScene;
import javafx.application.Application;
import javafx.stage.Stage;

public class Game extends Application {
    //ADD list of scenes
    public static final int MAX_SCENES = 3;
    public static final int WELCOME_SCENE = 0;
    public static final int GAME_SCENE = 1;
    public static final int LAST_SCENE = 2;


    public static final GeneralScene[] scenes = new GeneralScene[MAX_SCENES];

    private static Stage stage;


    @Override
    public void start(Stage primaryStage) throws Exception {
        this.stage = primaryStage;

        scenes[0] = new WelcomeScene();
        scenes[1] = new GameScene();

        setScene(WELCOME_SCENE);
        stage.setTitle("MZ Game");
        stage.show();
    }

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
