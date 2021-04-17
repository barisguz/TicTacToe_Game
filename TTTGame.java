/* Name : Baris Guzelsoy
   NetID: bguzelso
   I did not collaborate with anyone on this project. The code works perfectly.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

public class TTTGame extends JComponent implements ActionListener {

    private String clear = ""; // to clear each button after every game
    JPanel gameField = new JPanel();
    private int P1winCount = 0; //Player 1's Wins
    private int P2winCount = 0; //Player 2's Wins
    private int drawCount = 0;  // Total draws
    private JButton gameResetButton = new JButton("Reset Game"); // Our resetting button
    private JLabel playerTurn= new JLabel("   I    P1's Turn (x)   I     "); // Label to show the game condition
    private JLabel gameStats = new JLabel("<html>P1 Wins: " + P1winCount + "<br>P2 Wins: " + P2winCount + "<br>Draws:" + "   " + drawCount + "</html>");
    // label to show the stats (line 19)
    //Ps.I saw the code to adjust the variables in a vertical position in the lab session, so I hope that's alright.
    private JButton button0,button1,button2,button3,button4,button5,button6,button7,button8;
    private String signValue = "o"; //To determine whose turn it is, Since I've designed the algorithm
    // so that it reverses the first value,the initial value is set to "o"
    private boolean gameOver; // This value will be used to determine if the game is over.
    private JFrame gameFrame = new JFrame("Tic Tac Toe Game");

    public static void main(String args[]) {
        /* P.s. I had the idea of this section from Prof. Purtee's graphics class and with the
        help of internet,I implemented this in my code, I hope that's fine.
         */
        TTTGame gameBoard = new TTTGame();
        gameBoard.gameFrame.setVisible(true);
        gameBoard.gameFrame.setSize(480,580);
        gameBoard.gameFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        gameBoard.gameFrame.add(gameBoard);

        new TTTGame();
    }

    public TTTGame() {
        signValue = "o"; //Since I've designed the algorithm so that it reverses the first value,the initial value is set to "o".
        gameOver = false; // Since the game is just starting, the boolean is set to false.
        gameField.setSize(480,100);
        gameField.add(gameResetButton); // Adding the reset button
        gameField.add(playerTurn); // adding the button showing whose players turn it is and if someone won
        gameField.add(gameStats); // adding the button showing the stats
        add(gameField);

        adjustButtons(); // Adjusting the buttons with this.
        gameResetButton.addActionListener(this); // making sure the reset button can be interacted with.
    }
    // Adjusting and adding the buttons with which the "x" and "o" will be assigned.
    public void adjustButtons(){
        // Making the buttons resemble a game board rather than a keypad
        button0 = new transparentButton(clear);
        button1 = new transparentButton(clear);
        button2 = new transparentButton(clear);
        button3 = new transparentButton(clear);
        button4 = new transparentButton(clear);
        button5 = new transparentButton(clear);
        button6 = new transparentButton(clear);
        button7 = new transparentButton(clear);
        button8 = new transparentButton(clear);
        // making sure that the button can be changed
        button0.addActionListener(this);
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);
        button5.addActionListener(this);
        button6.addActionListener(this);
        button7.addActionListener(this);
        button8.addActionListener(this);
        // Adjusting the locations,widht and heights of the buttons
        button0.setBounds(100,100,80,80);
        button1.setBounds(200,100,80,80);
        button2.setBounds(300,100,80,80);
        button3.setBounds(100,200,80,80);
        button4.setBounds(200,200,80,80);
        button5.setBounds(300,200,80,80);
        button6.setBounds(100,300,80,80);
        button7.setBounds(200,300,80,80);
        button8.setBounds(300,300,80,80);
        // Adjusting the font and the size of the button
        button0.setFont(new Font(Font.DIALOG,Font.ITALIC,80));
        button1.setFont(new Font(Font.DIALOG,Font.ITALIC,80));
        button2.setFont(new Font(Font.DIALOG,Font.ITALIC,80));
        button3.setFont(new Font(Font.DIALOG,Font.ITALIC,80));
        button4.setFont(new Font(Font.DIALOG,Font.ITALIC,80));
        button5.setFont(new Font(Font.DIALOG,Font.ITALIC,80));
        button6.setFont(new Font(Font.DIALOG,Font.ITALIC,80));
        button7.setFont(new Font(Font.DIALOG,Font.ITALIC,80));
        button8.setFont(new Font(Font.DIALOG,Font.ITALIC,80));
        // Adding the buttons
        add(button0);
        add(button1);
        add(button2);
        add(button3);
        add(button4);
        add(button5);
        add(button6);
        add(button7);
        add(button8);
    }
    // With this, we will draw the game board
    public void paintComponent(Graphics g) {
        g.setColor(Color.BLUE);
        super.paintComponents(g);
        Graphics2D g2d = (Graphics2D) g;
        // The four lines that constitute the game grid is drawn
        g2d.draw(new Line2D.Double(90, 190, 390, 190));
        g2d.draw(new Line2D.Double(90, 290, 390, 290));
        g2d.draw(new Line2D.Double(190, 90, 190, 390));
        g2d.draw(new Line2D.Double(290, 90, 290, 390));
    }
    // With this, we control the game buttons and the gameReset button
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== gameResetButton) {
            eraseGameBoard();
        }
        if(e.getSource() == button0) {
            if(button0.getText().equals(clear) && !gameOver) {
                assignNextVal(); //Determining the following value of the button
                button0.setText(signValue);  //Assigning the value
                checkGameCondition();  // Checking if someone won or the game ended
            }
        }
        // repeating the same process for other buttons
        if(e.getSource() == button1) {
            if(button1.getText().equals(clear) && !gameOver) {
                assignNextVal();
                button1.setText(signValue);
                checkGameCondition();
            }
        }
        if(e.getSource() == button2) {
            if(button2.getText().equals(clear) && !gameOver) {
                assignNextVal();
                button2.setText(signValue);
                checkGameCondition();
            }
        }
        if(e.getSource() == button3) {
            if(button3.getText().equals(clear) && !gameOver) {
                assignNextVal();
                button3.setText(signValue);
                checkGameCondition();
            }
        }
        if(e.getSource() == button4) {
            if(button4.getText().equals(clear) && !gameOver) {
                assignNextVal();
                button4.setText(signValue);
                checkGameCondition();
            }
        }
        if(e.getSource() == button5) {
            if(button5.getText().equals(clear) && !gameOver) {
                assignNextVal();
                button5.setText(signValue);
                checkGameCondition();
            }
        }
        if(e.getSource() == button6) {
            if(button6.getText().equals(clear) && !gameOver) {
                assignNextVal();
                button6.setText(signValue);
                checkGameCondition();
            }
        }
        if(e.getSource() == button7) {
            if(button7.getText().equals(clear) && !gameOver) {
                assignNextVal();
                button7.setText(signValue);
                checkGameCondition();
            }
        }
        if(e.getSource() == button8) {
            if(button8.getText().equals(clear) && !gameOver) {
                assignNextVal();
                button8.setText(signValue);
                checkGameCondition();
            }
        }
    }
    // This is to erase the board and get it ready for the next game.
    private void eraseGameBoard() {
        signValue = "o"; // P1 always starts first, since I saw on piazza that we do not have to alternate,
        // Again, since assignNextVal() changes the value of the sign in the beggining, I assign this with an "o".
        playerTurn.setText("   I    P1's Turn! (x)    I     "); // Declaring whose turn it is when the game starts

        gameOver = false; // Game is starting
        button0.setText(clear);
        button1.setText(clear);
        button2.setText(clear);
        button3.setText(clear);
        button4.setText(clear);
        button5.setText(clear);
        button6.setText(clear);
        button7.setText(clear);
        button8.setText(clear);
    }
    // This assigns the value "x" or "o" to the next button clicked, organizing the order of the players.
    private void assignNextVal() {
        if(signValue.equals("x")) { // The current move is an "x"
            signValue = "o"; // The next move will be an "o"
            playerTurn.setText("   I    P1's Turn (x)   I     "); // The status panel is updated, stating whose turn it is.
        }
        else if (signValue.equals("o")){ // Same procedure as above.
            signValue = "x";
            playerTurn.setText("   I    P2's Turn (o)   I     ");
        }
    }
    /*
    This transparentButton method helps me make sure that the game grid
    doesn't look like a keypad. Thus eliminating the sides of the buttons.
     */
    // Another note, I also found the way of making the buttons transparent from the internet
// and implemented it with the help of the TA's.
    public class transparentButton extends JButton {
        public transparentButton(String transParent) {
            setContentAreaFilled(false); // Getting rid of the gray background of a button.
            setBorderPainted(false); // Getting rid of the "box" of the button
        }
    }

    private void checkGameCondition() { //Checking the win conditions
        // Checking the first column
        if(button0.getText().equals(signValue) && button3.getText().equals(signValue) && button6.getText().equals(signValue)) {
            if (signValue == "x") { // If the winning value is x, the following is executed
                playerTurn.setText("   I    P1 Wins! (x)    I     "); // The text changes to show that P1 (x) won.
                P1winCount = P1winCount + 1; // The wins of P1 is incremented
                gameStats.setText("<html>P1 Wins: " + P1winCount + "<br>P2 Wins: " + P2winCount + "<br>Draws: " + drawCount + "</html>");
                //the game Stats are updated.
            }
            else if(signValue == "o") { // same process as above, but when the winner is "o".
                playerTurn.setText("   I    P2 Wins! (o)    I     ");
                P2winCount = P2winCount + 1;
                gameStats.setText("<html>P1 Wins: " + P1winCount + "<br>P2 Wins: " + P2winCount + "<br>Draws: " + drawCount + "</html>");
                signValue = "x";
            }
            gameOver = true; // making sure that the boolean value of gameOver is true so that the buttons cant be changed.
        }
        //Checking the second column
        else if(button1.getText().equals(signValue) && button4.getText().equals(signValue) && button7.getText().equals(signValue)) {
            if (signValue == "x") {
                playerTurn.setText("   I    P1 Wins! (x)    I     ");
                P1winCount = P1winCount + 1;
                gameStats.setText("<html>P1 Wins: " + P1winCount + "<br>P2 Wins: " + P2winCount + "<br>Draws: " + drawCount + "</html>");
            }
            else if(signValue == "o") {
                playerTurn.setText("   I    P2 Wins! (o)    I     ");
                P2winCount = P2winCount + 1;
                gameStats.setText("<html>P1 Wins: " + P1winCount + "<br>P2 Wins: " + P2winCount + "<br>Draws: " + drawCount + "</html>");
                signValue = "x";
            }
            gameOver = true;
        }
        // Checking the third column
        else if(button2.getText().equals(signValue) && button5.getText().equals(signValue) && button8.getText().equals(signValue)) {
            if (signValue == "x") {
                playerTurn.setText("   I    P1 Wins! (x)    I     ");
                P1winCount = P1winCount + 1;
                gameStats.setText("<html>P1 Wins: " + P1winCount + "<br>P2 Wins: " + P2winCount + "<br>Draws: " + drawCount + "</html>");
            }
            else if(signValue == "o") {
                playerTurn.setText("   I    P2 Wins! (o)    I     ");
                P2winCount = P2winCount + 1;
                gameStats.setText("<html>P1 Wins: " + P1winCount + "<br>P2 Wins: " + P2winCount + "<br>Draws: " + drawCount + "</html>");
                signValue = "x";
            }
            gameOver = true;
        }
        // Checking diagonally
        else if(button0.getText().equals(signValue) && button4.getText().equals(signValue) && button8.getText().equals(signValue)) {
            if (signValue == "x") {
                playerTurn.setText("   I    P1 Wins! (x)    I     ");
                P1winCount = P1winCount + 1;
                gameStats.setText("<html>P1 Wins: " + P1winCount + "<br>P2 Wins: " + P2winCount + "<br>Draws: " + drawCount + "</html>");
            }
            else if(signValue == "o") {
                playerTurn.setText("   I    P2 Wins! (o)    I     ");
                P2winCount = P2winCount + 1;
                gameStats.setText("<html>P1 Wins: " + P1winCount + "<br>P2 Wins: " + P2winCount + "<br>Draws: " + drawCount + "</html>");
                signValue = "x";
            }
            gameOver = true;
        }
        // Check the other diagonal
        else if(button2.getText().equals(signValue) && button4.getText().equals(signValue) && button6.getText().equals(signValue)) {
            if (signValue == "x") {
                playerTurn.setText("   I    P1 Wins! (x)    I     ");
                P1winCount = P1winCount + 1;
                gameStats.setText("<html>P1 Wins: " + P1winCount + "<br>P2 Wins: " + P2winCount + "<br>Draws: " + drawCount + "</html>");
            }
            else if(signValue == "o") {
                playerTurn.setText("   I    P2 Wins! (o)    I     ");
                P2winCount = P2winCount + 1;
                gameStats.setText("<html>P1 Wins: " + P1winCount + "<br>P2 Wins: " + P2winCount + "<br>Draws: " + drawCount + "</html>");
                signValue = "x";
            }
            gameOver = true;
        }
        // Checking the first row
        else if(button0.getText().equals(signValue) && button1.getText().equals(signValue) && button2.getText().equals(signValue)) {
            if (signValue == "x") {
                playerTurn.setText("   I    P1 Wins! (x)    I     ");
                P1winCount = P1winCount + 1;
                gameStats.setText("<html>P1 Wins: " + P1winCount + "<br>P2 Wins: " + P2winCount + "<br>Draws: " + drawCount + "</html>");
            }
            else if(signValue == "o") {
                playerTurn.setText("   I    P2 Wins! (o)    I     ");
                P2winCount = P2winCount + 1;
                gameStats.setText("<html>P1 Wins: " + P1winCount + "<br>P2 Wins: " + P2winCount + "<br>Draws: " + drawCount + "</html>");
                signValue = "x";
            }
            gameOver = true;
        }
        // Checking the second row
        else if(button3.getText().equals(signValue) && button4.getText().equals(signValue) && button5.getText().equals(signValue)) {
            if (signValue == "x") {
                playerTurn.setText("   I    P1 Wins! (x)    I     ");
                P1winCount = P1winCount + 1;
                gameStats.setText("<html>P1 Wins: " + P1winCount + "<br>P2 Wins: " + P2winCount + "<br>Draws: " + drawCount + "</html>");
            }
            else if(signValue == "o") {
                playerTurn.setText("   I    P2 Wins! (o)    I     ");
                P2winCount = P2winCount + 1;
                gameStats.setText("<html>P1 Wins: " + P1winCount + "<br>P2 Wins: " + P2winCount + "<br>Draws: " + drawCount + "</html>");
                signValue = "x";
            }
            gameOver = true;
        }
        // Checking the third row
        else if(button6.getText().equals(signValue) && button7.getText().equals(signValue) && button8.getText().equals(signValue)) {
            if (signValue == "x") {
                playerTurn.setText("   I    P1 Wins! (x)    I     ");
                P1winCount = P1winCount + 1;
                gameStats.setText("<html>P1 Wins: " + P1winCount + "<br>P2 Wins: " + P2winCount + "<br>Draws: " + drawCount + "</html>");
            }
            else if(signValue == "o") {
                playerTurn.setText("   I    P2 Wins! (o)    I     ");
                P2winCount = P2winCount + 1;
                gameStats.setText("<html>P1 Wins: " + P1winCount + "<br>P2 Wins: " + P2winCount + "<br>Draws: " + drawCount + "</html>");
                signValue = "x";
            }
            gameOver = true;
        }
        else if(button0.getText() != clear && button1.getText() != clear && button1.getText() != clear && button2.getText() != clear &&
                button3.getText() != clear && button4.getText() != clear && button5.getText() != clear && button6.getText() != clear &&
                button7.getText() != clear && button8.getText() != clear) { //Checking the draw conditions
            playerTurn.setText("   I    It's a draw!    I     ");
            drawCount = drawCount + 1;
            gameStats.setText("<html>P1 Wins: " + P1winCount + "<br>P2 Wins: " + P2winCount + "<br>Draws: " + drawCount + "</html>");
            gameOver = true;
        }
    }
}
