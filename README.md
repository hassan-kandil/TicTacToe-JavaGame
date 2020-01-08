# Tic Tac Toe Game

######This is a Tic Tac Toe game built in java using the MVC (Model-View-Controller) pattern.

Game Instructions:

	1. Compile the game.java file using the following command: javac game.java
	2. Run the java class file in order to run the game using the following command: java game
	3. The player uses X and the computer uses O symbols and in order to win the game the player or the computer has to get three X's or three O's in a row
	   either horizontally, vertically or diagonally.
	4. The player enters the row and column numbers (0, 1, 2) of the slot on the board that he/she wants to draw the X on (row first and then the column).
	5. The computer sees if it can win or prevent the player from winning and plays its move accordingly or else it plays a random move.
	6. Step 4 and 5 repeat until either the player wins or the computer wins or the entire board is filled and in that case the game ends as a tie.
	7. The player chooses whether he/she wants a rematch and enters Y or y for a rematch and N or n to exit.



Implementation Notes:

	1. If the player enters coordinates of a box which is already filled or is not on the board, the game outputs an error and he/she can try again.
	2. The player can't exit in the middle of a game.
	3. The player should only enter numbers for the rows and columns (no characters), otherwise the game will crash.



