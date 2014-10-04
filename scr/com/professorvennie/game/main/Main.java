package com.professorvennie.game.main;

/**
 * Created by ProfessorVennie on 10/4/2014 at 3:26 PM.
 */
public class Main {

    private static Game game;

    public static Game getGame() {
        if (game != null)
            return game;
        else
            return new Game();
    }

    public static void main(String args[]) {
        game = new Game();
        game.start();
    }
}
