package GameLogic;

import Graphics.Gui;

/**
 * Created by Степан on 08.02.2017.
 */
public class Run {
    static Gamer gamer = new Gamer("Player1");
    static Gui gui = new Gui();

    static int gamerHits = -1;
    static int gamer2Hits = -1;
    static int condition = 0;
    public static void main(String[] args) {
        Gamer gamer = new Gamer("Player1");
        Gamer gamer2 = new Gamer("Player2");
        Gui gui = new Gui();
        gui.goGui(gamer);
        gui.goGui(gamer2);
    }


    public void run(Gamer player) {



}



}
