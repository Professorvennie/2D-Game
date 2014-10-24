package com.professorvennie.game.states;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ProfessorVennie on 10/22/2014 at 8:40 PM.
 */
public class StateManger {

    public static Map<Integer, IState> states = new HashMap<Integer, IState>();
    public static int currentStateID = 0;

    public StateManger() {
        addState(0, new MenuState());
        addState(1, new HelpState());
        addState(2, new SettingsState());
        addState(3, new PlayState());
    }

    public void addState(int id, IState state) {
        if (!states.containsKey(id))
            states.put(id, state);
    }

    public void removeState(int id) {
        if (states.containsKey(id))
            states.remove(id);
    }

    public IState getCurrentState() {
        if (states.containsKey(currentStateID))
            return states.get(currentStateID);
        return null;
    }

    public void setCurrentState(int stateID) {
        currentStateID = stateID;
    }

    public void render(Graphics g) {
        getCurrentState().render(g);
    }

    public void tick() {
        getCurrentState().tick();
    }

    public void handleInput(int key) {
        getCurrentState().handleInput(key);
    }
}
