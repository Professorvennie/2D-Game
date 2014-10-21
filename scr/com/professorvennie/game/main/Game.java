package com.professorvennie.game.main;

import com.professorvennie.game.handlers.KeyHandler;

import java.awt.*;
import java.awt.image.BufferStrategy;

/**
 * Created by ProfessorVennie on 10/4/2014 at 3:24 PM.
 */
public class Game extends Canvas implements Runnable {

    private Window window;
    private Thread thread;
    private boolean running = false;

    public synchronized void start() {
        if (running) return;
        running = true;
        init();
        thread = new Thread(Main.getGame());
        thread.start();
    }

    public synchronized void stop() {
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void init() {
        window = new Window(800, 600, "2D Game");
        Dimension size = new Dimension(window.getWidth(), window.getHeight());
        setPreferredSize(size);
        setMaximumSize(size);
        setMinimumSize(size);
        window.createWindow();
        addKeyListener(new KeyHandler());
    }

    public void render() {
        BufferStrategy bs = getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, window.getWidth(), window.getHeight());

        g.dispose();
        bs.show();

    }

    public void tick() {

    }

    @Override
    public void run() {
        while (running) {
            render();
        }
        stop();
    }
}
