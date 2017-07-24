package com.gmail.vladaavekin.Model;


public class Player {

    private final String Name;

    private final int[] Player;

    public Player(final String name, final int[] player) {
        Name = name;
        Player = player;
    }

    public String getName() {
        return Name;
    }

    public int[] getPlayer() {
        return Player;
    }

}
