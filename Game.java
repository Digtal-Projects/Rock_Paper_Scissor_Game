import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;
import java.lang.Math;

public class Game extends JFrame {
    private static int userScore = 0;
    private static int computerScore = 0;
    private static int tieRound = 0;
    private static int totalRound = 0;
    private static int winRate = 0;
    private static boolean roundComplete = true;
    private static int x = 0;

    public void start() {

        String[] items = { "ROCK", "PAPER", "SCISSOR" };
        Random random = new Random();
        final String[] randomItem = { items[random.nextInt(items.length)] };
        // System.out.println(randomItem[0]);

        Frame f = new Frame("Rock Paper Scissors Game");
        Label l2 = new Label("Creater : Parag Gawade");
        l2.setBounds(20, 10, 300, 60);
        f.add(l2);
        Label l = new Label("|=== ROCK PAPER SCISSORS GAME ===|");
        l.setBounds(70, 50, 300, 60);
        f.add(l);

        Label userScoreLabel = new Label("User Score: 0");
        userScoreLabel.setBounds(50, 210, 100, 30);
        f.add(userScoreLabel);

        Label computerScoreLabel = new Label("Computer Score: 0");
        computerScoreLabel.setBounds(50, 240, 120, 30);
        f.add(computerScoreLabel);

        Label gameTieLabel = new Label("Game Tie: 0");
        gameTieLabel.setBounds(50, 270, 100, 30);
        f.add(gameTieLabel);

        Label totalRoundLabel = new Label("Total Round: 0");
        totalRoundLabel.setBounds(50, 300, 100, 30);
        f.add(totalRoundLabel);

        Label winRateLabel = new Label("Win Rate: 0%");
        winRateLabel.setBounds(180, 300, 100, 30);
        f.add(winRateLabel);

        Label note1 = new Label("NOTE : 1. Computer has already decided it's choice.");
        note1.setBounds(40, 400, 300, 20);
        f.add(note1);
        Label note2 = new Label("2. You just need to click button to see result.");
        note2.setBounds(85, 420, 300, 20);
        f.add(note2);
        Label note3 = new Label("3. After result you can click reset for new round.");
        note3.setBounds(85, 440, 300, 20);
        f.add(note3);
        Label note4 = new Label("4. Win Rate shows probability of your winning.");
        note4.setBounds(85, 460, 300, 20);
        f.add(note4);
        Label note5 = new Label("5. Win Rate calculated using the won and lose");
        note5.setBounds(85, 480, 300, 20);
        f.add(note5);
        Label note6 = new Label("   and tie round as 50% chance.");
        note6.setBounds(87, 500, 300, 20);
        f.add(note6);

        Button b1 = new Button("ROCK");
        b1.setBounds(50, 120, 80, 30);
        f.add(b1);

        Button b2 = new Button("PAPER");
        b2.setBounds(150, 120, 80, 30);
        f.add(b2);

        Button b3 = new Button("SCISSOR");
        b3.setBounds(250, 120, 80, 30);
        f.add(b3);

        Button reset = new Button("RESET");
        reset.setBounds(50, 350, 80, 30);
        f.add(reset);

        Button closeButton = new Button("CLOSE");
        closeButton.setBounds(250, 350, 80, 30);
        f.add(closeButton);

        Label messageLabel = new Label("Start Game to see result");
        messageLabel.setBounds(80, 180, 250, 30);
        f.add(messageLabel);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!roundComplete) {
                    messageLabel.setText("Please click RESET for new round");
                    return;
                } else if (randomItem[0].equals("ROCK")) {
                    messageLabel.setText("Computer also chose 'ROCK' it's a tie");
                    tieRound++;
                    totalRound++;
                    gameTieLabel.setText("Game Tie: " + tieRound);
                    totalRoundLabel.setText("Total Round: " + totalRound);
                    winRateLabel.setText("Win Rate: " + winRate + "%");
                } else if (randomItem[0].equals("PAPER")) {
                    messageLabel.setText("Computer chose 'PAPER' you lose");
                    computerScore++;
                    totalRound++;
                    computerScoreLabel.setText("Computer Score: " + computerScore);
                    totalRoundLabel.setText("Total Round: " + totalRound);
                    winRateLabel.setText("Win Rate: " + winRate + "%");
                } else if (randomItem[0].equals("SCISSOR")) {
                    messageLabel.setText("Computer chose 'SCISSOR' you win");
                    userScore++;
                    totalRound++;
                    userScoreLabel.setText("User Score: " + userScore);
                    totalRoundLabel.setText("Total Round: " + totalRound);
                    winRateLabel.setText("Win Rate: " + winRate + "%");
                }
                roundComplete = false;
                x = computerScore + (tieRound / 2);
                winRate = ((x - totalRound) * 100) / totalRound;
                winRate = Math.abs(winRate);
            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!roundComplete) {
                    messageLabel.setText("Please click RESET for new round");
                    return;
                } else if (randomItem[0].equals("ROCK")) {
                    messageLabel.setText("Computer chose 'ROCK' you win");
                    userScore++;
                    totalRound++;
                    userScoreLabel.setText("User Score: " + userScore);
                    totalRoundLabel.setText("Total Round: " + totalRound);
                    winRateLabel.setText("Win Rate: " + winRate + "%");
                } else if (randomItem[0].equals("PAPER")) {
                    messageLabel.setText("Computer also chose 'PAPER' it's a tie");
                    tieRound++;
                    totalRound++;
                    gameTieLabel.setText("Game Tie: " + tieRound);
                    totalRoundLabel.setText("Total Round: " + totalRound);
                    winRateLabel.setText("Win Rate: " + winRate + "%");
                } else if (randomItem[0].equals("SCISSOR")) {
                    messageLabel.setText("Computer chose 'SCISSOR' you lose");
                    computerScore++;
                    totalRound++;
                    computerScoreLabel.setText("Computer Score: " + computerScore);
                    totalRoundLabel.setText("Total Round: " + totalRound);
                    winRateLabel.setText("Win Rate: " + winRate + "%");
                }
                roundComplete = false;
                x = computerScore + (tieRound / 2);
                winRate = ((x - totalRound) * 100) / totalRound;
                winRate = Math.abs(winRate);
            }
        });

        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!roundComplete) {
                    messageLabel.setText("Please click RESET for new round");
                    return;
                } else if (randomItem[0].equals("ROCK")) {
                    messageLabel.setText("Computer chose 'ROCK' you lose");
                    computerScore++;
                    totalRound++;
                    computerScoreLabel.setText("Computer Score: " + computerScore);
                    totalRoundLabel.setText("Total Round: " + totalRound);
                    winRateLabel.setText("Win Rate: " + winRate + "%");
                } else if (randomItem[0].equals("PAPER")) {
                    messageLabel.setText("Computer chose 'PAPER' you win");
                    userScore++;
                    totalRound++;
                    userScoreLabel.setText("User Score: " + userScore);
                    totalRoundLabel.setText("Total Round: " + totalRound);
                    winRateLabel.setText("Win Rate: " + winRate + "%");
                } else if (randomItem[0].equals("SCISSOR")) {
                    messageLabel.setText("Computer also chose 'SCISSOR' it's a tie");
                    tieRound++;
                    totalRound++;
                    gameTieLabel.setText("Game Tie: " + tieRound);
                    totalRoundLabel.setText("Total Round: " + totalRound);
                    winRateLabel.setText("Win Rate: " + winRate + "%");
                }
                roundComplete = false;
                x = computerScore + (tieRound / 2);
                winRate = ((x - totalRound) * 100) / totalRound;
                winRate = Math.abs(winRate);
            }
        });

        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                messageLabel.setText("Play Again");
                randomItem[0] = items[random.nextInt(items.length)];
                roundComplete = true;
                winRateLabel.setText("Win Rate: " + winRate + "%");
                // System.out.println(randomItem[0]);
            }
        });

        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                System.exit(0);
            }
        });

        f.setResizable(false);
        f.setSize(400, 550);
        f.setLayout(null);
        f.setVisible(true);
        System.out.println();
    }
}
