package com.mz.bear.scenes;

import javafx.scene.canvas.Canvas;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;

public abstract class GeneralScene extends Scene {
    public static final int GAME_WIDTH = 800;
    public static final int GAME_HEIGH = 480;

    private StackPane root;
    protected GraphicsContext gc;
    public GeneralScene() {

        //call to Scene constructor to initialize it
        super(new StackPane(), GAME_WIDTH, GAME_HEIGH);

        //change scene root to our own stack pane
        root = new StackPane();
        this.setRoot(root);

        //initialize canvas and graphics context
        Canvas canvas = new Canvas(GAME_WIDTH, GAME_HEIGH);
        root.getChildren().add(canvas);
        gc = canvas.getGraphicsContext2D();
    }

    public abstract void draw();
}
