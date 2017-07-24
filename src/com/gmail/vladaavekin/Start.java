package com.gmail.vladaavekin;


import com.gmail.vladaavekin.Model.Fields;
import com.gmail.vladaavekin.Model.Figure;
import com.gmail.vladaavekin.Model.Game;
import com.gmail.vladaavekin.Model.Player;
import com.gmail.vladaavekin.View.Console.ViewConsole;

public class Start {

    public static void main(String[] args) {

        String GameName = "XO-game";

        String name[] = new  String[2];
        name[0] = "Vlad";
        name[1] = "NoNeme";

        final Player[] players = new Player[2];
        players[0] = new Player(name[0], Figure.X);
        players[1] = new Player(name[1], Figure.Y);

        Game game = new Game(GameName, players, new Fields(3,3));

        final ViewConsole viewConsole = new ViewConsole();
        viewConsole.show(game);

        while (viewConsole.mowe(game)) {

            viewConsole.show(game);

        }


    }

}
