package GameLogic;

import Graphics.Gui;

/**
 * Created by Степан on 08.02.2017.
 */
public class Run {

    public static void main(String[] args) {
        Gamer gamer = new Gamer("Player1");
        Gamer gamer2 = new Gamer("Player2");
        Gui gui = new Gui();
        gui.goGui(gamer, gamer2);
    }



    public void run(Gamer player){


}



}
