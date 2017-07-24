package com.gmail.vladaavekin.Model;

public class Player {

    private final String Name;

    private final Figure figure;

    public Player(final String name, final Figure figure) {
        Name = name;
        this.figure = figure;
    }

    public String getName() {
        return Name;
    }

    public Figure getFigure() {
        return figure;
    }
}
