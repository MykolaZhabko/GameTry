package com.mz.platformer;

import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class Player extends Entity{
    private boolean canJump;
    private Point2D playerVelocity;

    public Player(Integer x, Integer y, Integer width, Integer height, Color color) {
        super(x, y, width, height, color);
    }

    public boolean isCanJump() {
        return canJump;
    }

    public void setCanJump(boolean canJump) {
        this.canJump = canJump;
    }

    public Point2D getPlayerVelocity() {
        return playerVelocity;
    }

    public void setPlayerVelocity(Point2D playerVelocity) {
        this.playerVelocity = playerVelocity;
    }
}
