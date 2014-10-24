package com.professorvennie.game.main;

import com.professorvennie.game.handlers.KeyHandler;
import com.professorvennie.game.states.StateManger;

import java.awt.*;
import java.awt.image.BufferStrategy;

/**
 * Created by ProfessorVennie on 10/4/2014 at 3:24 PM.
 */
public class Game extends Canvas implements Runnable {

    private static StateManger stateManger;
    private Window window;
    private Thread thread;
    private boolean running = false;

    public static StateManger getStateManger() {
        return stateManger;
    }

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
        stateManger = new StateManger();
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
        stateManger.render(g);

        g.dispose();
        bs.show();

    }

    public void tick() {
        stateManger.tick();
    }

    @Override
    public void run() {
        requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int updates = 0;
        int frames = 0;
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                updates++;
                delta--;
            }
            render();
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("FPS: " + frames + " TICKS: " + updates);
                window.getFrame().setTitle(window.getTitle() + "    |    " + "FPS: " + frames + " TICKS: " + updates);
                frames = 0;
                updates = 0;
            }
        }
        stop();
    }

    public Window getWindow() {
        return window;
    }
}
