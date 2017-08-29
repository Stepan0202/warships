package GameLogic;

/**
 * Created by Степан on 08.02.2017.
 */
public class Ship {
    String name;
    int size;
    public int hits = 0;
    public int[][] shipLocation;

    public Ship(int size) {
        this.size = size;
        shipLocation = new int[size][2];
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return this.size;
    }

    public void setShipLocation(int[][] massiv) {
        shipLocation = massiv;
    }

    public int[][] getShipLocation() {
        return shipLocation;
    }

    public boolean isAlive() {

        return hits != size;
    }

    public void placeAShip(int[][] cells) {
        int row = (int) (Math.random() * 10);
        int column = (int) (Math.random() * 10);

        int count = 1;
        int direction = (int) (Math.random() * 4); // direction in which ship will be placed
        for (int i = 0; i < this.size; i++) {

            switch (direction) {
                case 0:
                    if ((9 - row) > (this.size - count)) {
                        count++;
                        row++;

                    } else {
                        row--;
                        direction = 1;
                    }
                    break;
                case 1:
                    if ((row - this.size + count) > 0) {
                        count++;
                        row--;

                    } else {
                        row++;
                        direction = 0;
                    }
                    break;
                case 2:
                    if ((column - this.size + count) > 0) {
                        count++;
                        column--;

                    } else {
                        column++;
                        direction = 3;
                    }
                    break;
                case 3:
                    if ((9 - column) > (this.size - count)) {
                        count++;
                        column++;
                    } else {
                        column--;
                        direction = 2;
                    }
                    break;
            }
            if (cells[row][column] > 0) {
                System.out.println("It`s worked on " + count + " step" + ", number of the cell:" + row + column);
                placeAShip(cells);
                return;
            }
            shipLocation[i][0] = row;
            shipLocation[i][1] = column;
            cells[row][column] = 1;
        }
        Field.surroundCellByNumbers(shipLocation, cells, this.size, 3, 0);
    }

}
