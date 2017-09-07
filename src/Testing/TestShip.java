package Testing;


import GameLogic.Field;
import GameLogic.Gamer;
import GameLogic.Ship;

/**
 * Created by Степан on 08.02.2017.
 */
public class TestShip {
    public static void main(String[] args) {
        Gamer gamer = new Gamer("Player");

        Field field = new Field();
        Ship [] ships = gamer.getShips();
        for (int i = 0; i < 10; i++) {
            ships[i].placeAShip(field.getField());
            for(int j = 0; j < ships[i].getSize(); j++) {

                for(int g = 0; g < 2; g++) {

                   System.out.print(ships[i].getShipLocation()[j][g]);
                }
                System.out.print("   ");
            }
            System.out.println("");
        }
        for (int i = 0; i < 10; i++) {
            System.out.print(i+ "       ");
            for(int j = 0; j < 10; j++) {

                System.out.print(field.getField()[i][j] + "   ");
            }
            System.out.println("");
        }
        System.out.println("        ");
        System.out.print("        ");
        for(int i = 0; i < 10; i++) {
            System.out.print(i + "   ");
        }


    }
}

