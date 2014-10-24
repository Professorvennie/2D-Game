package com.professorvennie.game.states;

import java.awt.*;

/**
 * Created by ProfessorVennie on 10/22/2014 at 8:41 PM.
 */
public interface IState {

    public void render(Graphics g);

    public void tick();

    public void handleInput(int key);
}
