import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TicTacToe extends JFrame {

    private JButton[] buttons;
    private boolean xTurn;
    private int turnCount;

    public TicTacToe() {
        // Set up the frame
        setTitle("Tic Tac Toe");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the buttons
        buttons = new JButton[9];
        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            buttons[i].addActionListener(new ButtonListener());
        }

        // Add the buttons to the frame
        setLayout(new GridLayout(3, 3));
        for (JButton button : buttons) {
            add(button);
        }

        // Initialize game variables
        xTurn = true;
        turnCount = 0;

        // Show the frame
        setVisible(true);
    }

    private class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // Get the button that was clicked
            JButton button = (JButton) e.getSource();

            // Handle the turn
            if (button.getText().equals("")) {
                if (xTurn) {
                    button.setText("X");
                } else {
                    button.setText("O");
                }
                turnCount++;

                // Check for a winner
                if (checkForWinner()) {
                    JOptionPane.showMessageDialog(TicTacToe.this, "Player " + (xTurn ? "X" : "O") + " wins!");
                    resetGame();
                } else if (turnCount == 9) {
                    JOptionPane.showMessageDialog(TicTacToe.this, "Tie game!");
                    resetGame();
                } else {
                    xTurn = !xTurn;
                }
            }
        }
    }

    private boolean checkForWinner() {
        // Check rows
        for (int i = 0; i < 9; i += 3) {
            if (buttons[i].getText().equals(buttons[i + 1].getText()) && buttons[i].getText().equals(buttons[i + 2].getText()) && !buttons[i].getText().equals("")) {
                return true;
            }
        }

        // Check columns
        for (int i = 0; i < 3; i++) {
            if (buttons[i].getText().equals(buttons[i + 3].getText()) && buttons[i].getText().equals(buttons[i + 6].getText()) && !buttons[i].getText().equals("")) {
                return true;
           
            }
        }

        // Check diagonals
        if (buttons[0].getText().equals(buttons[4].getText()) && buttons[0].getText().equals(buttons[8].getText()) && !buttons[0].getText().equals("")) {
            return true;
        }
        if (buttons[2].getText().equals(buttons[4].getText()) && buttons[2].getText().equals(buttons[6].getText()) && !buttons[2].getText().equals("")) {
            return true;
        }

        return false;
    }

    private void resetGame() {
        for (JButton button : buttons) {
            button.setText("");
        }

        xTurn = true;
        turnCount = 0;
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
    }
}
