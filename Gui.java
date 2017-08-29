package Graphics;

import GameLogic.Field;
import GameLogic.Gamer;
import GameLogic.Ship;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Степан on 15.02.2017.
 */
public class Gui {
    JFrame frame;
    JLabel labelHits; // для счетчика попаданий
    JLabel labelShoots;// для счетчика выстрелов
    JPanel panelForButtons;
    JPanel panel;
    Field field;
    Gamer gamer;
    int shootCount;
    public int condition = 0;
    Ship temporaryShip;// присваиваем ссылку на объект, с которым работаем в данный момент
    public MyButton [][] fieldButtons;
    int [][] listOfIndexes;

    public void goGui(Gamer gamer){

        panelForButtons = new JPanel();
        frame = new JFrame(gamer.gamerName);
        labelHits = new JLabel("Hits: 0");
        labelShoots = new JLabel("Shoots: 0");
        this.gamer = gamer;
        this.field = gamer.getField();
        fieldButtons = new MyButton [10][10];
        listOfIndexes = new int [100][2];

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setVisible(true);
        frame.getContentPane().add(panelForButtons);

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {

                fieldButtons [i][j] = new MyButton("" + (j+1), i, j); // creating button, it`s name and location
                fieldButtons [i][j].setActionCommand(i + "" + j); // action when button is pressed
                fieldButtons [i][j].addActionListener(new FieldButtonsListener()); // add action listener
                fieldButtons [i][j].setBackground(Color.white);
                fieldButtons [i][j].setForeground(Color.white);
               panelForButtons.add(fieldButtons[i][j]); // add button on the frame
            }
        }
        panelForButtons.add(labelHits);
        panelForButtons.add(labelShoots);
    }
    public static void surroundCellByColor(int [][] shipLocation, int [][] cells, MyButton [][] fieldButtons, int shipSize, int equals ){
        for (int i = 0; i < shipSize; i++) {
            int a = shipLocation[i][0] - 1;
            int b = shipLocation[i][0] + 1;
            int c = shipLocation[i][1] - 1;
            int d = shipLocation[i][1] + 1;

            try {
                if (cells[a][shipLocation[i][1]] == equals) {
                    fieldButtons[a][shipLocation[i][1]].setBackground(Color.yellow);
                    fieldButtons[a][shipLocation[i][1]].setEnabled(false);
                }
            } catch (ArrayIndexOutOfBoundsException ar) {

            }
            try {
                if (cells[b][shipLocation[i][1]] == equals) {
                    fieldButtons[b][shipLocation[i][1]].setBackground(Color.yellow);
                    fieldButtons[b][shipLocation[i][1]].setEnabled(false);
                }
            }
            catch (ArrayIndexOutOfBoundsException ar){

            }
            try {
                if (cells[b][c] == equals) {
                    fieldButtons[b][c].setBackground(Color.yellow);
                    fieldButtons[b][c].setEnabled(false);
                }
            } catch (ArrayIndexOutOfBoundsException ar) {

            }
            try {
                if (cells[b][d] == equals) {
                    fieldButtons[b][d].setBackground(Color.yellow);
                    fieldButtons[b][d].setEnabled(false);
                }
            } catch (ArrayIndexOutOfBoundsException ar) {

            }
            try {
                if (cells[a][c] == equals) {
                    fieldButtons[a][c].setBackground(Color.yellow);
                    fieldButtons[a][c].setEnabled(false);
                }
            } catch (ArrayIndexOutOfBoundsException ar) {

            }
            try {
                if (cells[a][d] == equals) {
                    fieldButtons[a][d].setBackground(Color.yellow);
                    fieldButtons[a][d].setEnabled(false);
                }
            } catch (ArrayIndexOutOfBoundsException ar) {

            }
            try {
                if (cells[shipLocation[i][0]][d] == equals) {
                    fieldButtons[shipLocation[i][0]][d].setBackground(Color.yellow);
                    fieldButtons[shipLocation[i][0]][d].setEnabled(false);
                }
            } catch (ArrayIndexOutOfBoundsException ar) {

            }
            try {
                if (cells[shipLocation[i][0]][c] == equals) {
                    fieldButtons[shipLocation[i][0]][c].setBackground(Color.yellow);
                    fieldButtons[shipLocation[i][0]][c].setEnabled(false);
                }
            } catch (ArrayIndexOutOfBoundsException ar) {

            }

        }
    }



    class FieldButtonsListener implements ActionListener {
        public void actionPerformed(ActionEvent action) {
            gamer.shoots++;
            labelShoots.setText("Shoots: " + gamer.shoots);

            String a = action.getActionCommand();//         при
            int x = Integer.parseInt(a)/10;// нажатии на кнопку
            int y = Integer.parseInt(a)%10;// получаем её координаты

            fieldButtons[x][y].setBackground(Color.yellow);
            fieldButtons[x][y].setEnabled(false);
            boolean shoot = field.checkShoot(x, y);

            if (shoot) {
                //condition = 0;
                gamer.hits++;
                labelHits.setText("Hits: " + gamer.hits);

                for (int i = 0; i < 10; i++) { // ищем в массиве кораблей игрока по координатам кнопки,  корабль, в который попали, и присваиваем temporaryShip ссылку на него
                    int [][] coordinates = gamer.getShips()[i].getShipLocation();
                    for (int j = 0; j < coordinates.length; j++) {
                        if (coordinates[j][0] == x && coordinates[j][1] == y) {
                            temporaryShip = gamer.getShips()[i];
                            break;
                        }
                    }
                }

                temporaryShip.hits++;
                fieldButtons[x][y].setBackground(Color.RED);

                if (temporaryShip.isAlive() == false) {
                    System.out.println("kill");
                    Gui.surroundCellByColor(temporaryShip.getShipLocation(), gamer.getField().getField(), fieldButtons, temporaryShip.getSize(), 3);
                }
            }
            else {

                        for (int i = 0; i < 10; i++) {
                            for (int j = 0; j < 10; j++) {
                                fieldButtons[i][j].setEnabled(false);
                            }
                        }

                }
            }

        }
    }



