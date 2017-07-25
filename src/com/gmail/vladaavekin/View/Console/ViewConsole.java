package com.gmail.vladaavekin.View.Console;


import com.gmail.vladaavekin.Model.Fields;
import com.gmail.vladaavekin.Model.Figure;
import com.gmail.vladaavekin.Model.Game;
import com.gmail.vladaavekin.Model.exceptions.AlreadyOccupiedException;
import com.gmail.vladaavekin.Model.exceptions.InvalidPointException;
import com.gmail.vladaavekin.Сontroller.CurrentMoveController;
import com.gmail.vladaavekin.Сontroller.MoveController;
import com.gmail.vladaavekin.Сontroller.WinnerController;

import java.awt.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ViewConsole {

    private final CurrentMoveController currentMoveController = new CurrentMoveController();

    private final MoveController moveController = new MoveController();

    private final WinnerController winnerController = new WinnerController();

    public void show(Game game) {

        System.out.println("Game name: " + game.getNameGame());
        printField(game);

    }

    public boolean mowe(Game game){

        final Fields fields = game.getFields();
        final Figure currentFigure = currentMoveController.currentMove(fields);

        if (currentFigure == null) {

            final Figure winner = winnerController.getWinner(fields);

            if (winner == null) {

                System.out.println("Now Winners!!!");
                return false;

            } else {
                System.out.printf("Winners is %w:\n", winner);
                return false;
            }

        }

        System.out.format("Enter move point for: %s\n", currentFigure);

        final Point point = ascPoint();

        try {

            moveController.applyFigure(fields, point, currentFigure);

        } catch (InvalidPointException | AlreadyOccupiedException e){
            //e.printStackTrace();
            System.out.println("Point is invalid!");
        }

        return true;
    }

    public Point ascPoint () {

        return new Point(ascCoordinat("X") - 1, ascCoordinat("O") - 1);

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

    public int ascCoordinat(final String coordinatName) {

        System.out.format("Input %b: ", coordinatName);
        final Scanner scanner = new Scanner(System.in);

        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("FUUUC!!!");
            return ascCoordinat(coordinatName);
        }

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
