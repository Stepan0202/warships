package GameLogic;

/**
 * Created by Степан on 08.02.2017.
 */
public class Field {

    public Ship[] ships;
    public int [][] field = new int [10][10];


    public void setField(int[][] field) {
        this.field = field;
    }
    public int[][] getField() {
        return field;
    }

    public void createField() {
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++) {
                this.field[i][j] = 0;
            }
        }
    }

    public Field() {
        createField();
    }



    public boolean checkShoot(int x, int y) {
        boolean a = false;
        if (field[x][y] == 2) {
            a = false;
        }
        else if (field[x][y] == 0) {
            field[x][y] = 2;
            a = false;
        }
        else if (field[x][y] == 1) {
            field[x][y] = 2;
            a = true;

        }
        return a;
    }
    public static void surroundCellByNumbers(int [][] shipLocation, int [][] cells, int shipSize, int number, int equals ){
        for (int i = 0; i < shipSize; i++) {
            int a = shipLocation[i][0] - 1;
            int b = shipLocation[i][0] + 1;
            int c = shipLocation[i][1] - 1;
            int d = shipLocation[i][1] + 1;

            try {
                if (cells[a][shipLocation[i][1]] == equals) {
                    cells[a][shipLocation[i][1]] = number;
                }
            } catch (ArrayIndexOutOfBoundsException ar) {

            }
            try {
                if (cells[b][shipLocation[i][1]] == equals) {
                    cells[b][shipLocation[i][1]] = number;
                }
            }
            catch (ArrayIndexOutOfBoundsException ar){

            }
            try {
                if (cells[b][c] == equals) {
                    cells[b][c] = number;
                }
            } catch (ArrayIndexOutOfBoundsException ar) {

            }
            try {
                if (cells[b][d] == equals) {
                    cells[b][d] = number;
                }
            } catch (ArrayIndexOutOfBoundsException ar) {

            }
            try {
                if (cells[a][c] == equals) {
                    cells[a][c] = number;
                }
            } catch (ArrayIndexOutOfBoundsException ar) {

            }
            try {
                if (cells[a][d] == equals) {
                    cells[a][d] = number;
                }
            } catch (ArrayIndexOutOfBoundsException ar) {

            }
            try {
                if (cells[shipLocation[i][0]][d] == equals) {
                    cells[shipLocation[i][0]][d] = number;
                }
            } catch (ArrayIndexOutOfBoundsException ar) {

            }
            try {
                if (cells[shipLocation[i][0]][c] == equals) {
                    cells[shipLocation[i][0]][c] = number;
                }
            } catch (ArrayIndexOutOfBoundsException ar) {

            }

        }
    }

}

