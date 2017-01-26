
/**
 * 
 */
import java.util.Scanner;

/**
 * @author Haidan Meadows
 *  Mr. Hardman 
 *  Final Project, Tic-Tac-Toe 
 *  1/26/2017
 */
public class FinalProject {

	private static char[][] board = new char[3][3];

	public static void main(String[] args) {

		Scanner userInput = new Scanner(System.in);
		int row = -1;
		int column = -1;
		boolean player1Win = false;
		boolean player2Win = false;
		initBoard();
		displayBoard();

		System.out.println("Please enter a name for Player 1");
		String playerOne = userInput.next();

		System.out.println("Please enter a name for Player 2");
		String playerTwo = userInput.next();
		
		do {

			// asks player 1 where to place their X
			while (row == -1) {
				System.out.println(playerOne + ", please pick a row to place your X in");
				row = userInput.nextInt();

				// checks if designated row location is taken
				if (board[row][0] != ' ' && board[row][1] != ' ' && board[row][2] != ' ') {
					System.out.println("that row has no space, please pick another row");
					row = -1;
				}

			}

			while (column == -1) {
				System.out.println(playerOne + ", please pick a column to place your X in");
				column = userInput.nextInt();

				if (board[row][column] != ' ') {
					System.out.println("that spot is filled, please pick another");
					column = -1;
				}

			}

			// places X in specified position
			board[row][column] = 'X';

			displayBoard();

			player1Win = checkPlayerOneWin();

			if (player1Win == false  && (board[0][0] == ' ' || board[0][1] == ' ' || board[0][2] == ' ' || board[1][0] == ' ' || board[1][1] == ' ' || board[1][2] == ' ' || board[2][0] == ' ' || board[2][1] == ' ' || board[2][2] == ' ')) {

				row = -1;
				column = -1;

				// Asks player 2 where to place their O
				while (row == -1) {
					System.out.println(playerTwo + ", please pick a row to place your O in");
					row = userInput.nextInt();

					// checks if designated row location is taken
					if (board[row][0] != ' ' && board[row][1] != ' ' && board[row][2] != ' ') {
						System.out.println("that row has no space, please pick another row");
						row = -1;
					}
				}

				while (column == -1) {
					System.out.println(playerTwo + ", please pick a column to place your O in");
					column = userInput.nextInt();

					if (board[row][column] != ' ') {
						System.out.println("that spot is filled, please pick another");
						column = -1;
					}
				}

				// places O in specified position
				board[row][column] = 'O';
				displayBoard();

				player2Win = checkPlayerTwoWin();

				row = -1;
				column = -1;

			}
			
			
			/**
			 * @param loops player 1 and 2's turns as long as no one has one and there are open spots
			 *@return returns if either player 1 wins, player 2 wins, or there is a draw
			 */
		} while (player1Win == false && player2Win == false && (board[0][0] == ' ' || board[0][1] == ' ' || board[0][2] == ' ' || board[1][0] == ' ' || board[1][1] == ' ' || board[1][2] == ' ' || board[2][0] == ' ' || board[2][1] == ' ' || board[2][2] == ' '));
		
		if(player1Win == true){
			System.out.println("\nCongradulations " + playerOne + " you win!");
		}
		else if(player2Win == true){
			System.out.println("\nCongradulations " + playerTwo + " you win!");
		}
		else if(player2Win == false && player1Win == false){
			System.out.println("\nNo one has won, its a draw!");
		}
	}

	public static void initBoard() {
		// fills up the board with blanks
		for (int r = 0; r < 3; r++)
			for (int c = 0; c < 3; c++)
				board[r][c] = ' ';
	}

	public static void displayBoard() {
		System.out.println("  0  " + board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
		System.out.println("    --+-+--");
		System.out.println("  1  " + board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
		System.out.println("    --+-+--");
		System.out.println("  2  " + board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
		System.out.println("     0 1 2 ");
	}

	public static void displayBoard2() {
		for (int r = 0; r < 3; r++) {
			System.out.print("\t" + r + " ");
			for (int c = 0; c < 3; c++) {
				System.out.print(board[r][c] + " ");
			}
			System.out.println();
		}
		System.out.println("\t  0 1 2 ");
	}
	/**
	 * @param checks all scenarios for possible player one wins
	 * @return returns if player one has won
	 */
	public static boolean checkPlayerOneWin() {

		boolean playerOneWin = false;
		if (board[0][0] == 'X' && board[1][0] == 'X' && board[2][0] == 'X') {
			playerOneWin = true;
		} else if (board[0][1] == 'X' && board[1][1] == 'X' && board[2][1] == 'X') {
			playerOneWin = true;
		} else if (board[0][2] == 'X' && board[1][2] == 'X' && board[2][2] == 'X') {
			playerOneWin = true;
		} else if (board[0][0] == 'X' && board[0][1] == 'X' && board[0][2] == 'X') {
			playerOneWin = true;
		} else if (board[1][0] == 'X' && board[1][1] == 'X' && board[1][2] == 'X') {
			playerOneWin = true;
		} else if (board[2][0] == 'X' && board[2][1] == 'X' && board[2][2] == 'X') {
			playerOneWin = true;
		} else if (board[0][0] == 'X' && board[1][1] == 'X' && board[2][2] == 'X') {
			playerOneWin = true;
		} else if (board[0][2] == 'X' && board[1][1] == 'X' && board[2][0] == 'X') {
			playerOneWin = true;
		}
		return playerOneWin;
	}
	/**
	 * @param checks all scenarios for possible player two wins
	 * @return returns if player two has won
	 */
	public static boolean checkPlayerTwoWin() {

		boolean playerTwoWin = false;
		if (board[0][0] == 'O' && board[1][0] == 'O' && board[2][0] == 'O') {
			playerTwoWin = true;
		} else if (board[0][1] == 'O' && board[1][1] == 'O' && board[2][1] == 'O') {
			playerTwoWin = true;
		} else if (board[0][2] == 'O' && board[1][2] == 'O' && board[2][2] == 'O') {
			playerTwoWin = true;
		} else if (board[0][0] == 'O' && board[0][1] == 'O' && board[0][2] == 'O') {
			playerTwoWin = true;
		} else if (board[1][0] == 'O' && board[1][1] == 'O' && board[1][2] == 'O') {
			playerTwoWin = true;
		} else if (board[2][0] == 'O' && board[2][1] == 'O' && board[2][2] == 'O') {
			playerTwoWin = true;
		} else if (board[0][0] == 'O' && board[1][1] == 'O' && board[2][2] == 'O') {
			playerTwoWin = true;
		} else if (board[0][2] == 'O' && board[1][1] == 'O' && board[2][0] == 'O') {
			playerTwoWin = true;
		}

		return playerTwoWin;

	}

}
