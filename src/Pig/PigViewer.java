package Pig;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: E
 * Date: 11/1/13
 * Time: 11:48 AM
 * To change this template use File | Settings | File Templates.
 */
public class PigViewer {
    private JPanel panel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextArea textArea1;
    private JButton rollAgainButton;
    private JButton startOverButton;
    private JButton endTurnButton;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Order entry");
        frame.setContentPane(new PigViewer().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(600,600);
        frame.setVisible(true);
    }

    public PigViewer(){
        //Variable to hold the score.  Is it bad form to make it final?
        final Score score = new Score();

        class ResetListener implements ActionListener{
            //Resets the score and new game.
            @Override
            public void actionPerformed(ActionEvent e) {
                score.newGame();
                textField1.setText("" + (score.getPlayerScore()));
                textArea1.setText("Resetting the game.  New game--good luck!" +
                                   "\nPlayer your roll.");

                textField2.setText("" + score.getCompScore());
            }

        }

        //Attach the listener to the reset button.
        ActionListener resetButton = new ResetListener();
        startOverButton.addActionListener(resetButton);

        class PlayerListener implements ActionListener{
            int currentRoll;
            @Override
            public void actionPerformed(ActionEvent e) {
                //If the player presses the button and the game is in progress and it is the player's turn.
                if (score.isGameInProgress() && score.getPlayerTurn()){
                    //Get the roll and print its value.
                    currentRoll = score.getRoll();
                    textArea1.setText("You rolled " + currentRoll + ".\n");
                    //If the current roll equals 1, it is computer's turn.  Call the method for a roll of one.
                    if (currentRoll == 1){
                        textArea1.append("Uh-oh, you rolled a one. \nTurn is over.\n");
                        score.playerRolledOne();
                        score.setPlayerTurn(false);
                        textField1.setText("" + (score.getPlayerScore()));
                        //Computer's turn.  A separate method within the inner class that runs the computer's turn.
                        computerTurn();
                    }

                    //If the current roll is not one.
                    else{
                        //Add the score to the player's score and the current score and print the score.
                        score.addPlayerScore(currentRoll);
                        score.addCurrentScore(currentRoll);
                        textField1.setText("" + (score.getPlayerScore()));
                        //Check to see if the player has one.
                        if (score.getPlayerScore() >= 100){
                            textArea1.append("You won!!  Great job!");
                            score.setGameInProgress(false);
                        }
                        //
                        else{
                            textArea1.append("Choose either button to end turn or roll again.");
                        }
                    }
                }
            }

            public void computerTurn(){
                int computerRoll = 0;
                //Method to run the computer logic.  It would be nice to put it outside the inner class so the
                //other listener can access it too, but not sure how with the scope issues.  It has similar logic to
                //above except that it will end its turn when its run exceed 20.  This is the optimal way to play when
                //according to risk/reward.  Hopefully this deviation from the requirements is ok.
                while(computerRoll != 1 && score.isGameInProgress()){
                    textArea1.append("Rolling...\n");
                    //This was an attempt to make the game flow make sense with a computer pause when it rolled.
                    //Instead it made it freeze.  Thoughts?
                    //try{
                    //    TimeUnit.SECONDS.sleep(2);
                    //}
                    //catch(Exception ex){}
                    //Roll and change score.
                    computerRoll = score.getRoll();
                    System.out.println(computerRoll);
                    textArea1.append("Computer rolled a " + computerRoll + ".\n");
                    //If roll is one, undo score changes and return control to player.
                    if (computerRoll == 1){
                        textArea1.append("Back to your turn, player.\n");
                        score.setPlayerTurn(true);
                        score.compRolledOne();
                        textField2.setText(""+ score.getCompScore());
                        score.setPlayerTurn(true);
                    }
                    else{
                        //Score is not one.
                        score.addCompScore(computerRoll);
                        score.addCurrentScore(computerRoll);
                        textField2.setText("" + score.getCompScore());
                        //Check if computer won.
                        if (score.getCompScore()>100){
                            textArea1.append("\nComputer won!  Better luck next time.");
                            score.setGameInProgress(false);
                        }
                        //Computer didn't win, so if the current score is >20, return (exit method), otherwise continue.
                        else{
                            if (score.getCurrentScore() > 20){
                                score.setPlayerTurn(true);
                                score.setCurrentScore(0);
                                return;
                            }
                        }
                    }
                }
            }
        }

        ActionListener playerB= new PlayerListener();
        rollAgainButton.addActionListener(playerB);

        class EndTurnListener implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                computerTurn();
            }

            public void computerTurn(){
                //Exactly the same as the method above but in a different scope.
                int computerRoll = 0;
                if (score.getCurrentScore() == 0){
                    return;
                }
                score.setCurrentScore(0);
                while(computerRoll != 1 && score.isGameInProgress()){
                    textArea1.append("Rolling...\n");
                    //try{
                    //    TimeUnit.SECONDS.sleep(2);
                    //}
                    //catch(Exception ex){}
                    computerRoll = score.getRoll();
                    System.out.println(computerRoll);
                    textArea1.append("Computer rolled a " + computerRoll + ".\n");
                    System.out.println("** appended");
                    if (computerRoll == 1){
                        textArea1.append("Back to your turn, player.\n");
                        score.setPlayerTurn(true);
                        score.compRolledOne();
                        textField2.setText(""+ score.getCompScore());
                        score.setPlayerTurn(true);
                    }
                    else{
                        textField2.setText("" + score.getCompScore());
                        score.addCompScore(computerRoll);
                        score.addCurrentScore(computerRoll);
                        textField2.setText(""+ score.getCompScore());
                        if (score.getCompScore()>100){
                            textArea1.append("\nComputer won!  Better luck next time.");
                            score.setGameInProgress(false);
                            return;
                        }
                        else{

                            if (score.getCurrentScore() > 20){
                                score.setPlayerTurn(true);
                                score.setCurrentScore(0);
                                return;
                            }
                        }
                    }
                }
            }
        }

        ActionListener endTurnB= new EndTurnListener();
        endTurnButton.addActionListener(endTurnB);
    }

}




