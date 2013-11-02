package Pig;

/**
 * Created with IntelliJ IDEA.
 * User: E
 * Date: 11/1/13
 * Time: 5:27 PM
 * To change this template use File | Settings | File Templates.
 */
public class Score {
    //This class holds the variables of the game.  Important or non-getter/setters are commented below.

    private boolean gameInProgress;
    private boolean playerTurn;
    private int playerScore;
    private int compScore;
    private int currentScore;
    private final int WINNINGSCORE = 100;
    private int roll;

    public Score(){
        gameInProgress = true;
        int player = 1;
    }

    public boolean isGameInProgress() {
        return gameInProgress;
    }

    public void setGameInProgress(boolean gameInProgress) {
        this.gameInProgress = gameInProgress;
    }

    public boolean getPlayerTurn() {
        return playerTurn;
    }

    public void setPlayer(int player) {
        this.playerTurn = playerTurn;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public void setPlayerScore(int playerScore) {
        this.playerScore = playerScore;
    }

    public int getCompScore() {
        return compScore;
    }

    public void setCompScore(int compScore) {
        this.compScore = compScore;
    }

    public int getCurrentScore() {
        return currentScore;
    }

    public void setCurrentScore(int currentScore) {
        this.currentScore = currentScore;
    }

    public int getWINNINGSCORE() {
        return WINNINGSCORE;
    }

    public void resetRoundScore(){
        currentScore = 0;
    }

    public void newGame(){
        //Reset the variables so it is a new game.
        gameInProgress = true;
        playerTurn = true;
        playerScore = 0;
        compScore = 0;
        currentScore = 0;

    }

    public int addPlayerScore(int i){
        playerScore += i;
        return playerScore;
    }

    public int addCompScore(int i){
        compScore += i;
        return compScore;
    }

    public int addCurrentScore(int i){
        currentScore += i;
        return currentScore;
    }

    public int getRoll(){
        //Produce a roll that is a random number.
        return (int) (Math.random()*6 + 1);
    }

    public void playerRolledOne(){
        //Player rolled one.  Reset the current score count and subtract it from the player's total.
        playerScore -= currentScore;
        currentScore = 0;
    }

    public void compRolledOne(){
        //Computer rolled one.  Reset the current score count and subtract it from the computer's total.
        compScore -= currentScore;
        currentScore = 0;
    }

    public void setPlayerTurn(boolean t){
        playerTurn = t;
    }

}
