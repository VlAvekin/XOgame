package com.gmail.vladaavekin.Model;

import com.gmail.vladaavekin.Model.exceptions.InvalidPointException;
import java.awt.*;

public class Fields {

    private static final int MIN_COORDINATE = 0;

    private final int coordinateX;

    private final int coordinateY;

    private  Figure figures[][];

    public Fields(int coordinateX, int coordinateY, Figure[][] figures) {
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        this.figures = figures;
    }

    public int getCoordinateX() {
        return coordinateX;
    }

    public int getCoordinateY() {
        return coordinateY;
    }

    public Figure getFields(final Point point) throws InvalidPointException {


        return figures[point.x][point.y];
    }

    public void setFields(final Point point, final Figure figure) throws InvalidPointException {

        figures[point.x][point.y] = figure;
    }

    private boolean checkPoint(final Point point) {

        return checkCoordinate(point.x, figures.length) && checkCoordinate(point.y, figures[point.x].length);

    }

    private boolean checkCoordinate(final int coordinate, final int maxCoordinate) {

        return coordinate >= MIN_COORDINATE && coordinate < maxCoordinate;

    }

}
