package com.gmail.vladaavekin.Сontroller;

import com.gmail.vladaavekin.Model.Fields;
import com.gmail.vladaavekin.Model.Figure;
import com.gmail.vladaavekin.Model.exceptions.InvalidPointException;

import java.awt.*;

public class CurrentMoveController {

    public Figure currentMove(final Fields fields) {

        int counterFigure = 0;

        for (int x = 0; x < fields.getCoordinateX(); x++) {

            counterFigure += countFigureInTheRow(fields, x);

        }

        if (counterFigure == fields.getCoordinateX() * fields.getCoordinateY())
            return null;

        if (counterFigure % 2 == 0)
            return Figure.X;

        return Figure.O;

    }

    public int countFigureInTheRow(final Fields fields, final int row) {

        int countFigure = 0;

        for (int y = 0; y < fields.getCoordinateY(); y++) {

            try {

                if (fields.getFigure(new Point(row, y)) != null)
                    countFigure++;

            } catch (InvalidPointException e) {
                e.printStackTrace();
            }

        }

        return countFigure;
    }

}
