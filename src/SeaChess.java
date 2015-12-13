import java.util.Scanner;

public class SeaChess {
	public static void printArr(char[][] arr) {
		int x = arr.length;
		int y = arr[0].length;
		System.out.println(x + "," + y);
		for (int i = 0; i < y; i++) {
			System.out.print(" =");
		}
		System.out.println();

		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				System.out.print("|" + arr[i][j]);
			}
			System.out.println("|");
			System.out.println();
		}
		for (int i = 0; i < y; i++) {
			System.out.print(" =");
		}
	}

	static boolean isWinner(char player, char[][] arr) {
int sumWinner = 0;
		int[] sumArr = new int[2 * arr.length + 2];
		for (int i = 0; i < arr.length; i++) {
			sumWinner += player;
			for (int j = 0; j < arr[0].length; j++) {
				sumArr[i] += arr[i][j];
				sumArr[arr.length + j] += arr[i][j];
				if (i == j) {
					sumArr[2 * arr.length] += arr[i][j];
				}
				if (i + j == arr.length - 1) {
					sumArr[2 * arr.length + 1] += arr[i][j];
				}
			}
		}
		for (int i = 0; i < sumArr.length; i++) {
			if (sumArr[i] == sumWinner) {
				return true;
			}
		}

		return false;
	}
	static void play(char player , char[][] arr){
			Scanner sc = new Scanner(System.in);
			System.out.println("Въведете кординати за ход на играч " + player);
			System.out.println("По хоризонтала : ");
			int row=sc.nextInt();
			System.out.println("По вертикала : ");
			int col = sc.nextInt();
			if((row < 0) 
					|| (row >arr.length -1) 
					|| (col < 0) 
					|| (col >arr.length -1) 
					|| arr[row][col]!=' '){
				System.out.println("Невълидни кординати или запълнено поле.");
				 play(player,arr);
			}
			else{
				arr[row][col]=player;
			}
	}

	public static void main(String[] args) {
		int n = 3;
		char[][] arr = new char[n][n];

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				arr[i][j] = ' ';
			}
		}
		boolean haveWinner=false;
		int turn = 1;
		char player='X';
		do {
			play(player,arr);
			if(turn>=5){
				if(isWinner(player, arr)){
					haveWinner= true;
					System.out.println(player +" Победи!!!!!!!!");
				}
			}
			printArr(arr);
			turn++;
			System.err.println("tva e turn " + turn + " i n=" +n );
			if(player=='X'){
				player ='Y';
			}
			else{
				player='X';
			}
		} while (!haveWinner && turn<=n*n);
		
		if(!haveWinner)System.out.println("Никой няма да черпи за победата.");
	}
}
