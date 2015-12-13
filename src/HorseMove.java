import java.util.Scanner;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

public class HorseMove {

	public static void printArr(char[][] arr) {
		int x = arr.length;
		int y = arr[0].length;
		System.out.println( x + "," + y);
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

	static void horseMove(char[][] arr, int n, int m) {
		System.out.println(n + ", " + m);
		if (
				n >=0 
				&& n <= arr.length - 1 
				&& m >=0 
				&& m <= arr[0].length - 1
				&& arr[n][m] != 'X'
		) {
			arr[n][m] = 'X';

			horseMove(arr, n - 1, m - 2);
			horseMove(arr, n + 1, m - 2);
			horseMove(arr, n - 2, m - 1);
			horseMove(arr, n + 2, m - 1);
			horseMove(arr, n - 2, m + 1);
			horseMove(arr, n + 2, m + 1);
			horseMove(arr, n - 1, m + 2);
			horseMove(arr, n + 1, m + 2);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Въведете големина на мастрицата \n X = ");
		int x = sc.nextInt();
		System.out.println("Y = \n");
		int y = sc.nextInt();
		char[][] arr = new char[x][y];

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				arr[i][j] = ' ';
			}
		}
	

		
		System.out.println("Въведете кординати на стартовата точка.\n N = \n");
		int n = sc.nextInt();
		System.out.println("M = \n");
		int m = sc.nextInt();

		horseMove(arr, n, m);

		printArr(arr);

	}
}
