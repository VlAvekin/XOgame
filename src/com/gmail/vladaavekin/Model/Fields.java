package com.gmail.vladaavekin.Model;

import com.gmail.vladaavekin.Model.exceptions.InvalidPointException;
import java.awt.*;

public class Fields {

    private static final int MIN_COORDINATE = 0;

    private final int coordinateX;

    private final int coordinateY;

    private  Fields fields[][];

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

    public Fields getFields(final Point point) throws InvalidPointException {

        try (!checkPoint(point)) {
            throw new InvalidPointException();
        }

        return fields[point.x][point.y];
    }

    public void setFields(final Point point, final Fields figure) throws InvalidPointException {

        try(!checkPoint(point)) {
            throw new  InvalidPointException();
        }
        fields[point.x][point.y] = figure;

    }

    private boolean checkPoint(final Point point) {

        return checkCoordinate(point.x, fields.length) && checkCoordinate(point.y, fields[point.x].length);

    }

    private boolean checkCoordinate(final int coordinate, final int maxCoordinate) {

        return coordinate >= MIN_COORDINATE && coordinate < maxCoordinate;

    }
}
