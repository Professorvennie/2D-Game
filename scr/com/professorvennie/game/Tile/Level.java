package com.professorvennie.game.Tile;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ProfessorVennie on 10/23/2014 at 10:21 PM.
 */
public class Level {

    private List<Tile> tiles;

    public Level() {
        tiles = new ArrayList<Tile>();
    }

    public void addTile(Tile tile) {
        tiles.add(tile);
    }

    public void removeTile(Tile tile) {
        tiles.remove(tile);
    }

    public void render(Graphics g) {
        for (Tile t : tiles)
            t.render(g);
    }

    public void tick() {
        for (Tile t : tiles)
            t.tick();
    }
}
