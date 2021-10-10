package com.mz.jungle.scenes;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public abstract class GeneralScene extends Scene {
    //constants for game window size
    public final static int GAME_WIDTH = 800;
    public final static int GAME_HEIGHT = 480;

    private StackPane root;

    // gc is for all drawing
    protected GraphicsContext gc;

    protected Set<KeyCode> activeKeys;
    protected Set<KeyCode> releasedKeys;

    public GeneralScene() {
        super(new StackPane(), GAME_WIDTH, GAME_HEIGHT);

        root = new StackPane();
        this.setRoot(root);

        Canvas canvas = new Canvas(GAME_WIDTH, GAME_HEIGHT);
        root.getChildren().add(canvas);
        gc = canvas.getGraphicsContext2D();

        activeKeys = new HashSet<>();
        releasedKeys = new HashSet<>();

        this.setOnKeyPressed(event -> {
            activeKeys.add(event.getCode());
        });
        this.setOnKeyReleased(event -> {
            activeKeys.remove(event.getCode());
            releasedKeys.add(event.getCode());
        });

    }
    public abstract void draw();
}
