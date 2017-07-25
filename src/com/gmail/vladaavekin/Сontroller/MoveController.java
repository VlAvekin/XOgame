package com.gmail.vladaavekin.Сontroller;

import com.gmail.vladaavekin.Model.Fields;
import com.gmail.vladaavekin.Model.Figure;
import com.gmail.vladaavekin.Model.exceptions.AlreadyOccupiedException;
import com.gmail.vladaavekin.Model.exceptions.InvalidPointException;

import java.awt.*;

public class MoveController {

    public void applyFigure(final Fields fields,
                            final Point point,
                            final Figure figure) throws InvalidPointException, AlreadyOccupiedException {

        if (fields.getFigure(point) != null) {

            throw new AlreadyOccupiedException();

        }

        fields.setFields(point, figure);
    }

}
