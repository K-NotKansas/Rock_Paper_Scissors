import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

public class RockPaperScissorsFrame extends JFrame {

        JButton rock, paper, scissors, quit;
        JLabel playerWins, computerWins, ties;
        Icon rockIcon, paperIcon, scissorsIcon;
        JTextArea notif;
        JScrollPane notifPrintZone;
        JPanel main, wins, actions, notifs;

        int pw = 0;
        int cw = 0;
        int tiesn = 0;
        int computerMoveIndex;
        String computerMoveMade;
        ArrayList<String> compMoves = new ArrayList<>();
        Random r;

        public RockPaperScissorsFrame(){
            compMoves.add("Rock");
            compMoves.add("Paper");
            compMoves.add("Scissors");

            main = new JPanel();
            main.setLayout(new BorderLayout());

            plzMakeActionPane();
            main.add(actions, BorderLayout.SOUTH);
            plzMakeNotifPane();
            main.add(notifs, BorderLayout.CENTER);
            plzMakeWinsPane();
            main.add(wins, BorderLayout.NORTH);
            add(main);

            setSize(800, 430);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
        }


        public void plzMakeWinsPane () {
                wins = new JPanel();
                playerWins = new JLabel("Player Won: " + pw + " times", JLabel.CENTER);
                computerWins = new JLabel("Computer Won: " + cw + " times", JLabel.CENTER);
                ties = new JLabel("Tied: " + tiesn + " times", JLabel.CENTER);
                wins.add(playerWins);
                wins.add(computerWins);
                wins.add(ties);
            }
        public void plzMakeActionPane () {
                actions = new JPanel();
                actions.setLayout(new GridLayout(1, 4));
                rockIcon = new ImageIcon("src/Rock.png");
                paperIcon = new ImageIcon("src/Paper.png");
                scissorsIcon = new ImageIcon("src/Scissors.png");
                rock = new JButton(rockIcon);//PaperIcon);
                paper = new JButton(paperIcon);
                scissors = new JButton(scissorsIcon);//ScissorsIcon);
                quit = new JButton("Quit");
                r = new Random();

                rock.addActionListener((ActionEvent ae) -> {
                    computerMoveIndex = r.nextInt(0, 2);
                    computerMoveMade = compMoves.get(computerMoveIndex);

                    if (computerMoveMade == "Rock") {
                        tiesn++;
                        notif.append((String) "You Tied" + "\n");
                        ties.setText("Tied: " + tiesn + " times");
                    } else if (computerMoveMade == "Paper") {
                        cw++;
                        notif.append((String) "You Lost" + "\n");
                        computerWins.setText("Computer Won: " + cw + " times");
                    } else if (computerMoveMade == "Scissors") {
                        pw++;
                        notif.append((String) "You Won" + "\n");
                        playerWins.setText("Player Won: " + pw + " times");
                    }

                });

                paper.addActionListener((ActionEvent ae) -> {
                    computerMoveIndex = r.nextInt(0, 2);
                    computerMoveMade = compMoves.get(computerMoveIndex);

                    if (computerMoveMade == "Rock") {
                        pw++;
                        notif.append((String) "You Won" + "\n");
                        playerWins.setText("Player Won: " + pw + " times");
                    } else if (computerMoveMade == "Paper") {
                        tiesn++;
                        notif.append((String) "You Tied" + "\n");
                        ties.setText("Tied: " + tiesn + " times");
                    } else if (computerMoveMade == "Scissors") {
                        cw++;
                        notif.append((String) "You Lost" + "\n");
                        computerWins.setText("Computer Won: " + cw + " times");
                    }
                });

                scissors.addActionListener((ActionEvent ae) -> {
                    computerMoveIndex = r.nextInt(0, 2);
                    computerMoveMade = compMoves.get(computerMoveIndex);

                    if (computerMoveMade == "Rock") {
                        cw++;
                        notif.append((String) "You Lost" + "\n");
                        computerWins.setText("Computer Won: " + cw + " times");
                    } else if (computerMoveMade == "Paper") {
                        pw++;
                        notif.append((String) "You Won" + "\n");
                        playerWins.setText("Player Won: " + pw + " times");
                    } else if (computerMoveMade == "Scissors") {
                        tiesn++;
                        notif.append((String) "You Tied" + "\n");
                        ties.setText("Tied: " + tiesn + " times");
                    }
                });

                quit.addActionListener((ActionEvent ae) -> {
                    System.exit(0);
                });

                actions.add(rock);
                actions.add(paper);
                actions.add(scissors);
                actions.add(quit);

            }

        public void plzMakeNotifPane() {
            notifs = new JPanel();
            notif = new JTextArea(10,6);
            notif.setEditable(false);
            notifPrintZone = new JScrollPane(notif);

            notifs.add(notifPrintZone);


        }

}