package com.professorvennie.game.states;

import com.professorvennie.game.Tile.GrassTile;
import com.professorvennie.game.Tile.Level;
import com.professorvennie.game.main.Main;

import java.awt.*;

/**
 * Created by ProfessorVennie on 10/23/2014 at 10:09 PM.
 */
public class PlayState implements IState {

    private Level level;

    public PlayState() {
        level = new Level();
        for (int w = 0; w < Main.getGame().getWindow().getWidth(); w++) {
            for (int h = 0; h < Main.getGame().getWindow().getHeight(); h++) {
                int x = w + 16;
                int y = h + 16;
                level.addTile(new GrassTile(x, y));
            }
        }
    }

    @Override
    public void render(Graphics g) {
        level.render(g);
    }

    @Override
    public void tick() {

    }

    @Override
    public void handleInput(int key) {

    }
}
