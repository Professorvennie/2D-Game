package com.professorvennie.game.Tile;

import java.awt.*;

/**
 * Created by ProfessorVennie on 10/23/2014 at 10:19 PM.
 */
public abstract class Tile {

    private int x, y;

    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean isSolid() {
        return false;
    }

    public abstract void render(Graphics g);

    public abstract void tick();

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
