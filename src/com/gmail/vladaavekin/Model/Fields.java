package com.gmail.vladaavekin.Model;

public class Fields {

    private final int coordinateX;

    private final int coordinateY;

    private final Fields fields[][];

    public Fields(final int coordinateX, final int coordinateY) {
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        fields = new Fields[coordinateX][coordinateY];
    }

    public int getCoordinateX() {
        return coordinateX;
    }

    public int getCoordinateY() {
        return coordinateY;
    }

    public Fields[][] getFields() {
        return fields;
    }
}
