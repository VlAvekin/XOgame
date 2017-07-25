package com.gmail.vladaavekin.Сontroller;

// проверка на выграш

import com.gmail.vladaavekin.Model.Fields;
import com.gmail.vladaavekin.Model.Figure;
import com.gmail.vladaavekin.Model.exceptions.InvalidPointException;

import java.awt.*;

public class WinnerController {

    public Figure getWinner(final Fields fields) {

        try {

            for (int i = 0; i < 3; i++)
                if (chec(fields, new Point(i, 0), new Point(i, 1), new Point(i, 2)))
                    return fields.getFigure(new Point(i, 0));


            for (int i = 0; i < 3; i++)
                if (chec(fields, new Point(0, i), new Point(1, i), new Point(2, i)))
                    return fields.getFigure(new Point(0, i));

            if (chec(fields, new Point(0, 0), new Point(1, 1), new Point(2, 2)))
                    return fields.getFigure(new Point(0, 0));

            if (chec(fields, new Point(2, 0), new Point(1, 1), new Point(0, 2)))
                    return fields.getFigure(new Point(1, 1));



        } catch (InvalidPointException e) {
            e.printStackTrace();
        }
        return null;
    }

    private boolean chec(final Fields fields,
                         final Point p1,
                         final Point p2,
                         final Point p3) {

        try {

            if (fields.getFigure(p1) == null) return false;

            if (fields.getFigure(p2) == fields.getFigure(p2) &&
                    fields.getFigure(p1) == fields.getFigure(p3))
                return true;

        } catch (InvalidPointException e) {
            e.printStackTrace();
        }

        return false;
    }

}
