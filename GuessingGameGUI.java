// Task 02 - Guessing Game (Swing GUI version)
// Prodigy InfoTech Software Development Internship
// Made by Mansi - B.Tech Student
//
// Same logic as the console version but with a small Swing window.
//
// How to run:
//   javac GuessingGameGUI.java
//   java GuessingGameGUI

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GuessingGameGUI extends JFrame {

    // game range
    private static final int MIN_NUM = 1;
    private static final int MAX_NUM = 100;

    private int target;
    private int attempts = 0;
    private boolean won = false;

    private final Random rand = new Random();

    // ui stuff
    private final JLabel messageLabel = new JLabel();
    private final JLabel attemptsLabel = new JLabel("Attempts: 0");
    private final JTextField guessField = new JTextField();
    private final JButton guessBtn = new JButton("Guess");
    private final JButton resetBtn = new JButton("Reset");

    public GuessingGameGUI() {
        super("Guessing Game - Task 02 (Mansi)");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420, 280);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // title
        JLabel title = new JLabel("Guess the Number (1 - 100)", SwingConstants.CENTER);
        title.setFont(new Font("SansSerif", Font.BOLD, 18));
        title.setBorder(BorderFactory.createEmptyBorder(12, 12, 4, 12));
        add(title, BorderLayout.NORTH);

        // center panel
        JPanel center = new JPanel();
        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
        center.setBorder(BorderFactory.createEmptyBorder(8, 16, 8, 16));

        messageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        messageLabel.setFont(new Font("SansSerif", Font.PLAIN, 13));

        guessField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 32));
        guessField.setFont(new Font("SansSerif", Font.PLAIN, 14));

        attemptsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        attemptsLabel.setFont(new Font("SansSerif", Font.BOLD, 13));

        center.add(messageLabel);
        center.add(Box.createVerticalStrut(10));
        center.add(guessField);
        center.add(Box.createVerticalStrut(8));
        center.add(attemptsLabel);

        add(center, BorderLayout.CENTER);

        // buttons
        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        btnPanel.add(guessBtn);
        btnPanel.add(resetBtn);
        add(btnPanel, BorderLayout.SOUTH);

        // listeners
        ActionListener guessAction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleGuess();
            }
        };
        guessBtn.addActionListener(guessAction);
        guessField.addActionListener(guessAction); // press Enter to guess

        resetBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startNewGame();
            }
        });

        startNewGame();
    }

    private void startNewGame() {
        target = rand.nextInt(MAX_NUM - MIN_NUM + 1) + MIN_NUM;
        attempts = 0;
        won = false;
        messageLabel.setText("I picked a number between 1 and 100. Try to guess it!");
        messageLabel.setForeground(new Color(0x0c, 0x4a, 0x6e));
        attemptsLabel.setText("Attempts: 0");
        guessField.setText("");
        guessField.setEnabled(true);
        guessBtn.setEnabled(true);
        guessBtn.setText("Guess");
        resetBtn.setText("Reset");
        guessField.requestFocus();
    }

    private void handleGuess() {
        if (won) return;

        String input = guessField.getText().trim();
        if (input.isEmpty()) {
            messageLabel.setForeground(Color.RED);
            messageLabel.setText("Please enter your guess first.");
            return;
        }

        int guess;
        try {
            guess = Integer.parseInt(input);
        } catch (NumberFormatException ex) {
            messageLabel.setForeground(Color.RED);
            messageLabel.setText("That's not a valid whole number.");
            return;
        }

        if (guess < MIN_NUM || guess > MAX_NUM) {
            messageLabel.setForeground(Color.RED);
            messageLabel.setText("Number must be between " + MIN_NUM + " and " + MAX_NUM + ".");
            return;
        }

        attempts++;
        attemptsLabel.setText("Attempts: " + attempts);

        if (guess == target) {
            messageLabel.setForeground(new Color(0x06, 0x5f, 0x46));
            messageLabel.setText("Correct! You got it in " + attempts
                    + " attempt" + (attempts == 1 ? "" : "s") + ".");
            won = true;
            guessField.setEnabled(false);
            guessBtn.setEnabled(false);
            resetBtn.setText("Play Again");
        } else if (guess < target) {
            messageLabel.setForeground(new Color(0xb4, 0x53, 0x09));
            messageLabel.setText("Too low! Try a bigger number.");
        } else {
            messageLabel.setForeground(new Color(0xb9, 0x1c, 0x1c));
            messageLabel.setText("Too high! Try a smaller number.");
        }

        guessField.setText("");
        guessField.requestFocus();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GuessingGameGUI().setVisible(true);
            }
        });
    }
}
