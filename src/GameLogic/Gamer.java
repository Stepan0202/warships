package GameLogic;

/**
 * Created by Степан on 08.02.2017.
 */
public class Gamer {
    Ship [] ships = {new Ship(4), new Ship(3), new Ship(3), new Ship(2), new Ship(2), new Ship(2), new Ship(1), new Ship(1), new Ship(1), new Ship(1)};
    public int hits = 0;
    public int shoots = 0;
    public String gamerName;

    Field field;
    public Gamer(String name) {
        gamerName = name;
        field = new Field();
        for (int i = 0; i < ships.length; i++) {

            ships[i].placeAShip(field.getField());
        }

    }
    public Field getField(){
        return field;
    }
    public Ship[] getShips() {
        return ships;
    }

}
