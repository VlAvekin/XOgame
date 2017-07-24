package com.gmail.vladaavekin.View.Console;


import com.gmail.vladaavekin.Model.Fields;
import com.gmail.vladaavekin.Model.Figure;
import com.gmail.vladaavekin.Model.Game;
import com.gmail.vladaavekin.Model.exceptions.InvalidPointException;

import java.awt.*;
import java.util.Scanner;

public class ViewConsole {

    public void show(Game game) {

        System.out.println("Game name: " + game.getNameGame());
        printField(game);
        ascCoordinat();

    }

    public boolean mowe(Game game){

        return true;
    }

    public void printField(Game game) {

        final Fields fields = game.getFields();

        for (int i = 0; i < fields.getCoordinateX(); i++) {

            printFor(fields, i);

            if (i <= fields.getCoordinateX() - 2) {
                printSeparator(game.getFields());
            }

        }

    }

    public int ascCoordinat() {

        System.out.print("Input : ");
        Scanner scanner = new Scanner(System.in);
        int in = scanner.nextInt();
        return in;

    }

    public static void printFor(final Fields fields, final int x) {

        for (int y = 0; y < fields.getCoordinateY(); y++) {

            if (y == 0) System.out.print(" ");

            if (y < fields.getCoordinateY() ) {

                final Figure figure;

                try {

                    figure = fields.getFigure(new Point(x, y));

                } catch (final InvalidPointException e){
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }

                System.out.print(figure != null ? figure : " ");

                if (y != fields.getCoordinateY() - 1) {
                    System.out.print(" ▌ ");
                }
            }

        }
        System.out.println();
    }

    public static void printSeparator(final Fields fields){

        for (int i = 0; i <= fields.getCoordinateX() * 2; i++) {
           System.out.print("▀");
        }
        System.out.print("\n");
    }

}
