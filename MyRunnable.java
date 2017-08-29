package GameLogic;

import Graphics.Gui;

/**
 * Created by Степан on 23.04.2017.
 */
public class MyRunnable  implements Runnable {
    public void run() {
        Gamer gamer2 = new Gamer("Player2");
        Gui gui2 = new Gui();
        gui2.goGui(gamer2);
    }
}
