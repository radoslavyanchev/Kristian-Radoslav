import java.util.Scanner;

public class TicTacToe {

	public static final int EMPTY = 0;
	public static final int NONE = 0;
	public static final int USERX = 1;
	public static final int USERO = 2;
	public static final int DRAW = 3;
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int[][] board = new int[3][3];
		int turn = USERX;
		int winner;
		while (true) {
			validation(board, turn);
			print_board(board);
			winner = hasWon(board);
			if (winner != NONE)
				break;
			if (turn == USERX) {
				turn = USERO;
			} else {
				turn = USERX;
			}
		}
		switch (winner) {
		case USERX:
			System.out.println("Играч 1 печели!");
			break;
		case USERO:
			System.out.println("Играч 2 печели!");
			break;
		default:
			System.out.println("Равенство.");
			break;
		}
	}

	public static void validation(int[][] board, int turn) {
		boolean validInput = false;
		do {
			if (turn == USERX) {
				//System.out.print("Играч Х въведи желана позиция: ");
				System.out.print("1: ");
			} else {
				//System.out.print("Играч O въведи желана позиция: ");
				System.out.print("2: ");
			}
			int x = sc.nextInt() - 1;
			int y = sc.nextInt() - 1;
			if (x >= 0 && x < board.length && y >= 0 && y < board.length && board[x][y] == EMPTY) {
				board[x][y] = turn;
				validInput = true;
			} else {
				System.out.println("Това място (" + (x + 1) + "," + (y + 1) + ") не е валидно. Опитай пак...");
			}
		} while (!validInput);
	}

	public static int hasWon(int[][] board) {
		if ((board[0][0] == board[0][1]) && (board[0][1] == board[0][2]))
			return board[0][0];
		if ((board[1][0] == board[1][1]) && (board[1][1] == board[1][2]))
			return board[1][0];
		if ((board[2][0] == board[2][1]) && (board[2][1] == board[2][2]))
			return board[2][0];
		if ((board[0][0] == board[1][0]) && (board[1][0] == board[2][0]))
			return board[0][0];
		if ((board[0][1] == board[1][1]) && (board[1][1] == board[2][1]))
			return board[0][1];
		if ((board[0][2] == board[1][2]) && (board[1][2] == board[2][2]))
			return board[0][2];
		if ((board[0][0] == board[1][1]) && (board[1][1] == board[2][2]))
			return board[0][0];
		if ((board[0][2] == board[1][1]) && (board[1][1] == board[2][0]))
			return board[0][2];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[i][j] == EMPTY) {
					return NONE;
				}
			}
		}
		return DRAW;
	}

	public static void print_board(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				System.out.print(printSymbols(board[i][j]));
				if (j != board.length - 1) {
					System.out.print("|");
				}
			}
			System.out.println();
			if (i != board.length - 1) {
				System.out.println("-----");
			}
		}
		System.out.println();
	}

	public static char printSymbols(int content) {
		switch (content) {
		case 1:
			return 'X';
		case 2:
			return 'O';
		default:
			return ' ';
		}
	}
}