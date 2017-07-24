package com.gmail.vladaavekin.View.Console;


import com.gmail.vladaavekin.Model.Fields;
import com.gmail.vladaavekin.Model.Game;

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

        for (int i = 0; i < fields.getCoordinateY(); i++) {

            if (i == 0) System.out.print(" ");

            if (i < fields.getCoordinateY() ) {
                System.out.print(fields.getFields()[x][i] != null ? fields.getFields()[x][i] : " ");

                if (i != fields.getCoordinateY() - 1) {
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
