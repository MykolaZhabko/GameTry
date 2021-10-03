package com.mz.platformer;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.control.Label;
import jdk.nashorn.internal.ir.Block;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Main extends Application {

    private HashMap<KeyCode, Boolean> keys = new HashMap<>();

    private ArrayList<Node> buildBlocks = new ArrayList<>();

    private Pane appRoot = new Pane();
    private Pane gameRoot = new Pane();
    private Pane uiRoot = new Pane();
    private Label playerLabel = new Label();

    private VBox vbox = new VBox();

    private Node player;
    private Point2D playerVelocity = new Point2D(0,0);
    private boolean canJump = true;

    private int levelWidth;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        initGameContent();

        Scene scene = new Scene(appRoot);
        scene.setOnKeyPressed(event -> keys.put(event.getCode(),true));
        scene.setOnKeyReleased(event -> keys.put(event.getCode(), false));

        primaryStage.setTitle("THE GAME");
        primaryStage.setScene(scene);
        primaryStage.show();

        //this timer gives 60 frames per second
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                update();
            }
        };
        timer.start();
    }

    private void update() {
        if (isPressed(KeyCode.W) && player.getTranslateY() >= 5){
            jumpPlayer();
        }
        if (isPressed(KeyCode.A) && player.getTranslateX() >= 5){
            movePlayerX(-5);
        }
        if (isPressed(KeyCode.D) && player.getTranslateX() + 40 <= levelWidth - 5){
            movePlayerX(5);
        }
        if (playerVelocity.getY() < 10){
            playerVelocity = playerVelocity.add(0,1);
        }

       movePlayerY((int)playerVelocity.getY());
       playerLabel.setText("Player position - X: "+ player.getTranslateX() + "Y: " + player.getTranslateY());
    }

    private void movePlayerY(int value) {
       boolean movingDown = value > 0;
        for (int i = 0; i < Math.abs(value); i++) {
            for (Node block : buildBlocks){
                if ((player.getTranslateX() + 40 >= block.getTranslateX() && player.getTranslateX() <= block.getTranslateX() + 60) && (player.getTranslateY() <= block.getTranslateY()+60 && player.getTranslateY() >= block.getTranslateY())){
                    if (movingDown){
                        if (player.getTranslateY() + 40 == block.getTranslateY()){
                            player.setTranslateY(player.getTranslateY() - 1);
                            canJump = true;
                            return;
                        }
                    } else {
                        if (player.getTranslateY() == block.getTranslateY()){
                            return;
                        }
                    }
                }
            }
            player.setTranslateY(player.getTranslateY() + (movingDown ? 1 : -1));
        }



    }

    private void movePlayerX(int value) {
        boolean movingRight = value > 0;

        for (int i = 0; i < Math.abs(value); i++) {
            for (Node block: buildBlocks){
                if (player.getTranslateX()+40 >= block.getTranslateX()
                        && (player.getTranslateY() >= block.getTranslateY() && player.getTranslateY() +40 <= block.getTranslateY()+60 )
                || player.getTranslateX() <= block.getTranslateX()+60
                        && (player.getTranslateY() >= block.getTranslateY() && player.getTranslateY() +40 <= block.getTranslateY()+60 )){
                    System.out.println("player X: " + player.getTranslateX());
                    if(movingRight){
                        if(player.getTranslateX() + 40 == block.getTranslateX()){
                            System.out.println("BLOCK bound in parent: " + block.getBoundsInParent());
                                                        return;
                        }
                    }else {
                        if (player.getTranslateX() == block.getTranslateX() + 60){
                            System.out.println("BLOCK bound in parent: " + block.getBoundsInParent());
                            return;
                        }
                    }

                }
            }

            player.setTranslateX(player.getTranslateX() + (movingRight ? 1 : -1));
        }
    }

    private void jumpPlayer() {
        if (canJump){
            playerVelocity = playerVelocity.add(0,-30);
            canJump = false;
        }
    }

    private boolean isPressed(KeyCode key) {
       return keys.getOrDefault(key,false);
    }

    private void initGameContent() {
        Rectangle bg = new Rectangle(3600, 780);

        levelWidth = Level.LEVEL1[0].length() * 60;

        for (int i = 0; i < Level.LEVEL1.length; i++) {
            String line = Level.LEVEL1[i];
            for (int j = 0; j < line.length(); j++) {
                Node block;
                switch (line.charAt(j)){
                    case '1':
                        block = createGameBlock(j*60,i*60,60,60, Color.web("#B5781D"));
                        buildBlocks.add(block);
                        break;
                    case '2':
                        block = createGameBlock(j*60,i*60,60,60, Color.web("#1DB52C"));
                        buildBlocks.add(block);
                        break;
                }
            }
        }

        player = createGameBlock(300,680,40,40,Color.BLUE);

        player.translateXProperty().addListener((obs, old,newValue) -> {
            int offset = newValue.intValue();

            if (offset > 640 && offset <levelWidth - 640){
                gameRoot.setLayoutX(-(offset-640));
            }
        });
        playerLabel.setTranslateX(0);
        playerLabel.setTranslateY(0);
        playerLabel.setTextFill(Color.WHITE);
        playerLabel.setText("Player position - X: " + player.getTranslateX() + "Y: " + player.getTranslateY());
        uiRoot.getChildren().add(playerLabel);
        appRoot.getChildren().addAll(bg,gameRoot,uiRoot);
    }

    private Node createGameBlock(int x, int y, int w, int h, Color color) {
        Rectangle block = new Rectangle(w,h);
        block.setTranslateX(x);
        block.setTranslateY(y);
        block.setFill(color);

        gameRoot.getChildren().add(block);
        return block;
    }
}
