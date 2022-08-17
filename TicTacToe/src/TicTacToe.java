import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class TicTacToe implements ActionListener {

    //constants of the game
    static final int NUM_OF_BUTTONS = 9;
    static final int HEIGHT = 800;
    static final int WIDTH = 800;
    static final int FONT_SIZE = 75;
    static final int TITLE_BOUND_WIDTH = WIDTH;
    static final int TITLE_BOUND_HEIGHT = 100;
    static final int TITLE_BOUND_X_AXIS_START = 0;
    static final int TITLE_BOUND_Y_AXIS_START = 0;
    static final int GRID_LAYOUT_HORIZONTAL = 3;
    static final int GRID_LAYOUT_VERTICAL = 3;
    static final String GAME_NAME = "Tic Tac Toe";
    static int places = 9;

    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel text_field = new JLabel();

    JButton[] buttons = new JButton[NUM_OF_BUTTONS];
    boolean player1_turn = true; // if false, then is player2 turns
                                //  player1 is X
    TicTacToe(){

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH,HEIGHT);
        frame.getContentPane().setBackground(Color.red);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        text_field.setBackground(Color.black);
        text_field.setForeground(Color.blue);
        text_field.setFont(new Font("Ink Free", Font.BOLD, FONT_SIZE));
        text_field.setHorizontalAlignment(JLabel.CENTER);
        text_field.setText(GAME_NAME);
        text_field.setOpaque(true);

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(TITLE_BOUND_X_AXIS_START, TITLE_BOUND_Y_AXIS_START, TITLE_BOUND_WIDTH, TITLE_BOUND_HEIGHT);

        button_panel.setLayout(new GridLayout(GRID_LAYOUT_HORIZONTAL, GRID_LAYOUT_VERTICAL));
        button_panel.setBackground(Color.green);

        for(int i = 0; i < NUM_OF_BUTTONS; i++){
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli", Font.BOLD, FONT_SIZE));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        title_panel.add(text_field);
        frame.add(title_panel, BorderLayout.NORTH);
        frame.add(button_panel);

        firstTurn();
    }
    @Override
    public  void actionPerformed(ActionEvent e){

        for(int i = 0; i < NUM_OF_BUTTONS; i++){
            if(e.getSource() == buttons[i]){

                if(player1_turn && buttons[i].getText() == ""){
                    buttons[i].setForeground(Color.red);
                    buttons[i].setText("X");
                    player1_turn = false;
                    text_field.setText("O turn");
                    check();
                }
                else if(buttons[i].getText() == "") {
                    buttons[i].setForeground(Color.blue);
                    buttons[i].setText("O");
                    player1_turn = true;
                    text_field.setText("X turn");
                    check();
                }

            }
        }
    }
    public void firstTurn(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e){
          e.printStackTrace();
        }
        String msg;
        if(!random.nextBoolean()){
            player1_turn = true;
            msg = "X turn";
        }
        else {
            player1_turn = false;
            msg = "O turn";
        }

        text_field.setText(msg);
    }
    public void check(){
        places--;
        if(places <= 0){
            tie();
        }
        //check X win conditions
        if(
                (buttons[0].getText()=="X") &&
                        (buttons[1].getText()=="X") &&
                        (buttons[2].getText()=="X")
        ) {
            xWins(0,1,2);
        }
        if(
                (buttons[3].getText()=="X") &&
                        (buttons[4].getText()=="X") &&
                        (buttons[5].getText()=="X")
        ) {
            xWins(3,4,5);
        }
        if(
                (buttons[6].getText()=="X") &&
                        (buttons[7].getText()=="X") &&
                        (buttons[8].getText()=="X")
        ) {
            xWins(6,7,8);
        }
        if(
                (buttons[0].getText()=="X") &&
                        (buttons[3].getText()=="X") &&
                        (buttons[6].getText()=="X")
        ) {
            xWins(0,3,6);
        }
        if(
                (buttons[1].getText()=="X") &&
                        (buttons[4].getText()=="X") &&
                        (buttons[7].getText()=="X")
        ) {
            xWins(1,4,7);
        }
        if(
                (buttons[2].getText()=="X") &&
                        (buttons[5].getText()=="X") &&
                        (buttons[8].getText()=="X")
        ) {
            xWins(2,5,8);
        }
        if(
                (buttons[0].getText()=="X") &&
                        (buttons[4].getText()=="X") &&
                        (buttons[8].getText()=="X")
        ) {
            xWins(0,4,8);
        }
        if(
                (buttons[2].getText()=="X") &&
                        (buttons[4].getText()=="X") &&
                        (buttons[6].getText()=="X")
        ) {
            xWins(2,4,6);
        }
        //check O win conditions
        if(
                (buttons[0].getText()=="O") &&
                        (buttons[1].getText()=="O") &&
                        (buttons[2].getText()=="O")
        ) {
            oWins(0,1,2);
        }
        if(
                (buttons[3].getText()=="O") &&
                        (buttons[4].getText()=="O") &&
                        (buttons[5].getText()=="O")
        ) {
            oWins(3,4,5);
        }
        if(
                (buttons[6].getText()=="O") &&
                        (buttons[7].getText()=="O") &&
                        (buttons[8].getText()=="O")
        ) {
            oWins(6,7,8);
        }
        if(
                (buttons[0].getText()=="O") &&
                        (buttons[3].getText()=="O") &&
                        (buttons[6].getText()=="O")
        ) {
            oWins(0,3,6);
        }
        if(
                (buttons[1].getText()=="O") &&
                        (buttons[4].getText()=="O") &&
                        (buttons[7].getText()=="O")
        ) {
            oWins(1,4,7);
        }
        if(
                (buttons[2].getText()=="O") &&
                        (buttons[5].getText()=="O") &&
                        (buttons[8].getText()=="O")
        ) {
            oWins(2,5,8);
        }
        if(
                (buttons[0].getText()=="O") &&
                        (buttons[4].getText()=="O") &&
                        (buttons[8].getText()=="O")
        ) {
            oWins(0,4,8);
        }
        if(
                (buttons[2].getText()=="O") &&
                        (buttons[4].getText()=="O") &&
                        (buttons[6].getText()=="O")
        ) {
            oWins(2,4,6);
        }

    }
    public void xWins(int a, int b, int c){
        buttons[a].setBackground(Color.green);
        buttons[b].setBackground(Color.green);
        buttons[c].setBackground(Color.green);
        for(int i = 0; i < NUM_OF_BUTTONS; i++){
            buttons[i].setEnabled(false);
        }
        text_field.setText("X Wins");
    }
    public void oWins(int a, int b, int c){
        buttons[a].setBackground(Color.green);
        buttons[b].setBackground(Color.green);
        buttons[c].setBackground(Color.green);
        for(int i = 0; i < NUM_OF_BUTTONS; i++){
            buttons[i].setEnabled(false);
        }
        text_field.setText("O Wins");
    }

    public void tie(){
        for(int i = 0; i < NUM_OF_BUTTONS; i++){
            buttons[i].setBackground(Color.pink);
            buttons[i].setEnabled(false);
        }
        text_field.setText("Tie");

    }
}
