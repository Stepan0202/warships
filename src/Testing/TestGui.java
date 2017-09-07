package Testing;

import GameLogic.Gamer;
import Graphics.Gui;

/**
 * Created by Степан on 15.02.2017.
 */
public class TestGui {

    public static void main(String[] args) {
        Gui test = new Gui(); // Когда один объект, его поля инциализируются разными  объектами геймер и получается херня. Передумать, переделать.
        Gui test2 = new Gui();
        Gamer gamer = new Gamer("Player1");
        Gamer gamer2 = new Gamer("Player2");

        test.goGui(gamer, gamer2);
        //test.goGui(gamer2);
        //test2.goGui(gamer);
    }

}
