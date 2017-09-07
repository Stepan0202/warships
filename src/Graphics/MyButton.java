package Graphics;

import javax.swing.*;

/**
 * Created by Степан on 25.02.2017.
 */
public class MyButton extends JButton {
    static int [] myButtonLocation = new int [2];

    public MyButton(String name, int a, int b) {
        super(name);
        myButtonLocation [0] = a;
        myButtonLocation [1] = b;
    }

    public static int[] getMyButtonLocation() {
        return myButtonLocation;
    }
}
