package com.professorvennie.game.Tile;

import java.awt.*;

/**
 * Created by ProfessorVennie on 10/23/2014 at 10:25 PM.
 */
public class GrassTile extends Tile {

    public GrassTile(int x, int y) {
        super(x, y);
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(getX(), getY(), 16, 16);
    }

    @Override
    public void tick() {

    }
}
