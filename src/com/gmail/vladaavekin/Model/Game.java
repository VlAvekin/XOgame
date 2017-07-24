package com.gmail.vladaavekin.Model;


public class Game {

    private final String NameGame;

    private final Player[] player;

    private final Fields fields;

    public Game(final String nameGame, final Player[] player, final Fields fields) {
        NameGame = nameGame;
        this.player = player;
        this.fields = fields;
    }

    public String getNameGame() {
        return NameGame;
    }

    public Player[] getPlayer() {
        return player;
    }

    public Fields getFields() {
        return fields;
    }
}
