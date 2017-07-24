package com.gmail.vladaavekin.Сontroller;

// проверка на выграш

import com.gmail.vladaavekin.Model.Fields;
import com.gmail.vladaavekin.Model.Figure;
import com.gmail.vladaavekin.Model.exceptions.InvalidPointException;

import java.awt.*;

public class WinnerController {

    public Figure getWinner(final Fields fields) {

        try {

            for (int i = 0; i < 3; i++) {



            }

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

            if (fields.getFields(p1) == null) return false;

            if (fields.getFields(p2) == fields.getFields(p2) &&
                    fields.getFields(p1) == fields.getFields(p3))
                return true;

        } catch (InvalidPointException e) {
            e.printStackTrace();
        }

    }

    private interface IPointGenerator {

        Point next(final Point point);

    }
}
