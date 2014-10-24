package com.professorvennie.game.states;

import com.professorvennie.game.main.Main;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by ProfessorVennie on 10/22/2014 at 8:45 PM.
 */
public class MenuState implements IState {

    private String[] options;
    private int currentSelction;

    public MenuState() {
        options = new String[4];
        options[0] = "Play";
        options[1] = "Help";
        options[2] = "Settings";
        options[3] = "Exit";
    }

    @Override
    public void render(Graphics g) {
        FontMetrics fm = g.getFontMetrics();
        for (int i = 0; i < options.length; i++) {
            int x = (Main.getGame().getWindow().getWidth() - fm.stringWidth(options[i])) / 2;
            g.setFont(new Font("Arial", Font.PLAIN, 22));
            if (currentSelction == i)
                g.setColor(Color.RED);
            else
                g.setColor(Color.white);
            g.drawString(options[i], x, 300 + i * 22);
        }
    }

    @Override
    public void tick() {

    }

    @Override
    public void handleInput(int key) {
        if (key == KeyEvent.VK_UP) {
            switch (currentSelction) {
                case 0:
                    currentSelction = 3;
                    break;
                default:
                    currentSelction--;
                    break;
            }
        }

        if (key == KeyEvent.VK_DOWN) {
            switch (currentSelction) {
                case 3:
                    currentSelction = 0;
                    break;
                default:
                    currentSelction++;
                    break;
            }
        }

        if (key == KeyEvent.VK_ENTER) {
            switch (currentSelction) {
                case 0:
                    Main.getGame().getStateManger().setCurrentState(3);
                    break;
                case 1:
                    Main.getGame().getStateManger().setCurrentState(1);
                    break;
                case 2:
                    Main.getGame().getStateManger().setCurrentState(2);
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.err.println("Unknown selection");
                    break;
            }
        }
    }
}
