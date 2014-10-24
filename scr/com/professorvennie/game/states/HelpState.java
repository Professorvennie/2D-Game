package com.professorvennie.game.states;

import com.professorvennie.game.main.Main;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by ProfessorVennie on 10/23/2014 at 10:13 PM.
 */
public class HelpState implements IState {

    @Override
    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.setFont(new Font("Arial", Font.BOLD, 30));
        g.drawString("Helping", 400, 300);
    }

    @Override
    public void tick() {

    }

    @Override
    public void handleInput(int key) {
        if (key == KeyEvent.VK_ENTER)
            Main.getGame().getStateManger().setCurrentState(0);
    }
}
