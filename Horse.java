import java.util.Scanner;

public class Horse {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Въведете размери на матрицата: ");
		int n = sc.nextInt();
		int m = sc.nextInt();
		char[][] arr = new char[n][m];
		System.out.print("Въведете координати на коня:");
		int x = sc.nextInt();
		int y = sc.nextInt();
		if (x < 0 || x >= arr.length || y < 0 || y >= arr[0].length) {
			System.out.println("Некоректно въведени стойности за коня.");
			sc.close();
			return;
		}
		initialization(arr);
		horsePath(arr, x, y);
		printMatrix(arr);
		sc.close();
	}

	static void horsePath(char[][] a, int x, int y) {
		if (x >= a.length || x < 0 || y >= a[0].length || y < 0) {
			return;
		}
		if (a[x][y] == '.') {
			return;
		} else {
			a[x][y] = '.';
		}
		horsePath(a, x - 2, y + 1);
		horsePath(a, x - 2, y - 1);
		horsePath(a, x - 1, y + 2);
		horsePath(a, x + 1, y + 2);
		horsePath(a, x + 2, y + 1);
		horsePath(a, x + 2, y - 1);
		horsePath(a, x + 1, y - 2);
		horsePath(a, x - 1, y - 2);
	}

	static void initialization(char[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				a[i][j] = ' ';
			}
		}
	}

	static void printMatrix(char[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				System.out.print("|"+ a[i][j]);
			}
			System.out.print("|"+ '\n');
		}
	}
}