package com.professorvennie.game.main;

import javax.swing.*;

/**
 * Created by ProfessorVennie on 10/4/2014 at 3:25 PM.
 */
public class Window {

    int width, height;
    String title;
    private JFrame frame;

    public Window(int width, int height, String title) {
        this.width = width;
        this.height = height;
        this.title = title;
        frame = new JFrame(title);
    }

    public void createWindow() {
        frame.add(Main.getGame());
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getTitle() {
        return title;
    }

    public JFrame getFrame() {
        return frame;
    }
}
