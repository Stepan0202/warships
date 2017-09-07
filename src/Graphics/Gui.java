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
    JFrame frame2;
    JLabel labelHits;// для счетчика попаданий
    JLabel labelHits2;// для счетчика попаданий
    JLabel labelShoots;// для счетчика выстрелов
    JLabel labelShoots2;// для счетчика выстрелов
    JPanel panelForHiddenButtons;
    JPanel panelForHiddenButtons2;
    JPanel panelForOpenButtons;
    JPanel panelForOpenButtons2;
    JPanel panelForGameFields;
    JPanel panelForGameFields2;

    Field field;
    Field field2;
    Gamer gamer;
    Gamer gamer2;

    int shootCount;
    public int condition = 0;
    Ship temporaryShip;// присваиваем ссылку на объект, с которым работаем в данный момент
    public MyButton [][] fieldOpenButtons;
    public MyButton [][] fieldOpenButtons2;
    public MyButton [][] fieldHiddenButtons;
    public MyButton [][] fieldHiddenButtons2;
    int [][] listOfIndexes;
    int [][] listOfIndexes2;

    public void goGui(Gamer gamer, Gamer gamer2){

        this.gamer = gamer;
        this.gamer2 = gamer2;
        this.field = gamer.getField();
        this.field2 = gamer2.getField();

        labelHits = new JLabel("Hits: 0");
        labelHits2 = new JLabel("Hits: 0");
        labelShoots = new JLabel("Shoots: 0");
        labelShoots2 = new JLabel("Shoots: 0");

        panelForHiddenButtons = new JPanel();
        panelForHiddenButtons2 = new JPanel();
        panelForHiddenButtons.setSize(100, 100);
        panelForHiddenButtons2.setSize(100, 100);

        panelForOpenButtons =  new JPanel();
        panelForOpenButtons2 = new JPanel();
        panelForOpenButtons.setSize(100, 100);
        panelForOpenButtons2.setSize(100, 100);



        panelForGameFields = new JPanel();
        panelForGameFields.setLayout(new BoxLayout(panelForGameFields, 0));
        panelForGameFields.setSize(200, 200);
        panelForGameFields2 = new JPanel();
        panelForGameFields2.setLayout(new BoxLayout(panelForGameFields2, 0));

        panelForGameFields.add(panelForOpenButtons);
        panelForGameFields.add(panelForHiddenButtons2);
        panelForGameFields2.add(panelForOpenButtons2);
        panelForGameFields2.add(panelForHiddenButtons);

        frame = new JFrame(gamer.gamerName);
        frame.setSize(300,300);
        frame2 = new JFrame(gamer2.gamerName);


        fieldHiddenButtons = new MyButton [10][10];
        fieldHiddenButtons2 = new MyButton [10][10];
        fieldOpenButtons = new MyButton[10][10];
        fieldOpenButtons2 = new MyButton[10][10];
        listOfIndexes = new int [100][2];

        createGamersHidenGraphicFields(fieldHiddenButtons, panelForHiddenButtons);
        createGamersHidenGraphicFields(fieldHiddenButtons2, panelForHiddenButtons2);
        createGamersOpenGraphicFields(gamer, fieldOpenButtons, panelForOpenButtons);
        createGamersOpenGraphicFields(gamer2, fieldOpenButtons2, panelForOpenButtons2);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setVisible(true);
        frame.getContentPane().add(panelForGameFields);


        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setSize(500, 500);
        frame2.setVisible(true);
        frame2.getContentPane().add(panelForGameFields2);

    }

    private void createGamersHidenGraphicFields(MyButton [][] fieldHiddenButtons, JPanel panelForHiddenButtons){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                fieldHiddenButtons[i][j] = new MyButton("" + (j+1), i, j); // creating button, it`s name and location
                fieldHiddenButtons[i][j].setActionCommand(i + "" + j); // action when button is pressed
                fieldHiddenButtons[i][j].addActionListener(new FieldButtonsListener()); // add action listener
                fieldHiddenButtons[i][j].setBackground(Color.white);
                fieldHiddenButtons[i][j].setForeground(Color.white);
                panelForHiddenButtons.add(fieldHiddenButtons[i][j]); // add button on the frame
            }
        }
        panelForHiddenButtons.setLayout(new GridLayout(10, 10));
    }
    private void createGamersOpenGraphicFields(Gamer gamer, MyButton [][] fieldOpenButtons, JPanel panelForOpenButtons){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                fieldOpenButtons[i][j] = new MyButton("" + (j+1), i, j); // creating button, it`s name and location
                fieldOpenButtons[i][j].setActionCommand(i + "" + j); // action when button is pressed
                fieldOpenButtons[i][j].addActionListener(new FieldButtonsListener()); // add action listener
            if (gamer.getField().getField()[i][j] == 1){
                fieldOpenButtons[i][j].setBackground(Color.green);
                fieldOpenButtons [i][j].setForeground(Color.green);
            }
            else {
                fieldOpenButtons[i][j].setBackground(Color.white);
                fieldOpenButtons[i][j].setForeground(Color.white);
            }
                panelForOpenButtons.add(fieldOpenButtons[i][j]); // add button on the frame
            }
        }
        panelForOpenButtons.setLayout(new GridLayout(10, 10));
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

            fieldHiddenButtons[x][y].setBackground(Color.yellow);
            fieldHiddenButtons[x][y].setEnabled(false);
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
                fieldHiddenButtons[x][y].setBackground(Color.RED);

                if (temporaryShip.isAlive() == false) {
                    System.out.println("kill");
                    Gui.surroundCellByColor(temporaryShip.getShipLocation(), gamer.getField().getField(), fieldHiddenButtons, temporaryShip.getSize(), 3);
                }
            }
            else {

                        for (int i = 0; i < 10; i++) {
                            for (int j = 0; j < 10; j++) {
                                fieldHiddenButtons[i][j].setEnabled(false);
                            }
                        }

                }
            }

        }
    }



