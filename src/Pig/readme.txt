The program is arranged around a GUI with three buttons.  There is a reset button that starts the game over, a roll
button which allows the player to roll and a stop button which ends the player's turn.  Rolls and player messages
are logged in the text box.  Score is calculated for player and computer.  When it is the computers turn, the computer
will roll in a manner similar to the player, not instantaneously but taking some time.

Variables--these will be added in a class with the appropriate methods:
boolean gameInProgress --whether the game is in progress or has ended
int player --designate player 1 (player) or player 2 (computer)
playerScore --store the score of player 1
computerScore --store the score of computer
currentRoundScore --store the score of the current round
winningScore -- final static constant 100

Methods for new game button:
//New game button will reset a game that is in progress or that has ended.  It will run anytime the button is pressed.
//Both methods will be called from the constructor also.
New game --reset the score variables to 0 and the gameInProgress to true
Print instructions --print instructions for the player in the text box.

Control flow of game for the player:
--Start game, everything 0.
--Player one rolls.
    --if roll = 1, player turn is over; if player score is deprecated back to the score at turn start and current Round
                score is set to zero. Current player is changed to computer.
    --else if score > 100, player wins.  Print winning message.  Change game in progress to false
    --else player score is added to total and working total
--Player one turn ends by choice

Control flow for the computer:
//The logic is the computer will keep going until the current total is greater than 20 or a one comes up.  THis is the
//optimal way to play.  The expected loss is (1/6)*current score.  The expected gain is 2+3+4+5+6 = 20/6.  So optimally
//it makes sense to keep rolling until the potential loss outweighs the gain, which is when the current score is >20.
--Computer takes control.
--Prints "rolling..." and waits a second
--Prints rolled a random num
--If it is 1, deprecate back to start of turn score, zero the current round score.  Print message rolled one,
        print message player's turn
--else if i is not 1, add it to the total score and current working score.  If score is not > 20, print "rolling...",
        keep rolling
--else if current working score is greater than 20, stop rolling.  Zero current score variable, change control to player
        print message to player

Known problems:
--The window keeps re-sizing depending on what is printed.  The GUI is pretty confusing to use.
--Also, the code seem to be very procedural and it uses a final Score object so that all the different listener classes
can access it.  Is this bad form?  Also, very confused wth the scope of different things.  How would I define the logic
for the computer in one place but where two different inner listener classes could access it?
--Finally, there is no separate driver class.  Like I said, understanding the scope of these things is problematic