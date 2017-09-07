package Testing;

import GameLogic.Field;
import GameLogic.Ship;

/**
 * Created by Степан on 08.02.2017.
 */
public class TestField {
    public static void main(String[] args) {
        Field field = new Field();


        Ship[] ships = field.ships;

        int [][] cells =  field.field;
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++) {
                System.out.print(cells[i][j] + "  ");
            }
            System.out.println("");
        }
        for (int i = 0; i < 4; i++){
           int [][] test = ships[0].getShipLocation();
            for (int j = 0; j < 2; j++) {
                System.out.print(test[i][j]);
            }

            System.out.println("");
        }
        System.out.println(field.ships[0].getSize());
        System.out.println(field.ships[9].getShipLocation()[0][0] + " " + field.ships[9].getShipLocation()[0][1]);
    }
}
