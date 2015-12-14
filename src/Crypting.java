
public class Crypting {

	public static void main(String[] args) {
		String text = "atextmextpevoqakbvccso";
		char[][] codingTable = { { 'B', 'M', 'S', 'J', 'C' }, { 'I', 'F', 'N', 'T', 'E' }, { 'R', 'L', 'A', 'H', 'K' },
				{ 'D', 'O', 'G', 'Q', 'V' }, { 'U', 'W', 'X', 'Y', 'P' } };
		System.out.println(text);
		String p = encrypt(text, codingTable);
		System.out.println(p);
		System.out.println(decrypt(p, codingTable));
	}

	static String encrypt(String text, char[][] codingTable) {
		if (text.length() % 2 != 0) {
			text += 'p';
		}
		text = text.toUpperCase();
		String newText = "";
		for (int i = 0; i < text.length(); i += 2) {
			char firstLetter = text.charAt(i);
			char secondLetter = text.charAt(i + 1);
			int rowFL = -1, colFL = -1, rowSL = -1, colSL = -1;
			for (int j = 0; j < codingTable.length; j++) {
				for (int k = 0; k < codingTable.length; k++) {
					if (codingTable[j][k] == firstLetter) {
						rowFL = j;
						colFL = k;
					}
					if (codingTable[j][k] == secondLetter) {
						rowSL = j;
						colSL = k;
					}
				}
			}
			if (rowFL == rowSL) {
				if (colFL == 4) {
					colFL = 0;
				} else {
					colFL++;
				}
				if (colSL == 4) {
					colSL = 0;
				} else {
					colSL++;
				}
				newText = addText(rowFL, colFL, rowSL, colSL, newText, codingTable);
			} else if (colFL == colSL) {
				if (rowFL == 4) {
					rowFL = 0;
				} else {
					rowFL++;
				}
				if (rowSL == 4) {
					rowSL = 0;
				} else {
					rowSL++;
				}
				newText = addText(rowFL, colFL, rowSL, colSL, newText, codingTable);
			} else {
				newText = addText(rowFL, colSL, rowSL, colFL, newText, codingTable);
			}
		}
		return newText;
	}

	static String decrypt(String text, char[][] codingTable) {
		String newText = "";
		for (int i = 0; i < text.length(); i += 2) {
			char firstLetter = text.charAt(i);
			char secondLetter = text.charAt(i + 1);
			int rowFL = -1, colFL = -1, rowSL = -1, colSL = -1;
			for (int j = 0; j < codingTable.length; j++) {
				for (int k = 0; k < codingTable.length; k++) {
					if (codingTable[j][k] == firstLetter) {
						rowFL = j;
						colFL = k;
					}
					if (codingTable[j][k] == secondLetter) {
						rowSL = j;
						colSL = k;
					}
				}
			}
			if (rowFL == rowSL) {
				if (colFL == 0) {
					colFL = 4;
				} else {
					colFL--;
				}
				if (colSL == 0) {
					colSL = 4;
				} else {
					colSL--;
				}
				newText = addText(rowFL, colFL, rowSL, colSL, newText, codingTable);
			} else if (colFL == colSL) {
				if (rowFL == 0) {
					rowFL = 4;
				} else {
					rowFL--;
				}
				if (rowSL == 0) {
					rowSL = 4;
				} else {
					rowSL--;
				}
				newText = addText(rowFL, colFL, rowSL, colSL, newText, codingTable);
			} else {
				newText = addText(rowFL, colSL, rowSL, colFL, newText, codingTable);
			}
		}
		newText = newText.toLowerCase();
		// if (newText.charAt(newText.length() - 1) == 'p') {
		// newText = newText.substring(0, newText.length() - 1);
		// }
		return newText;
	}

	static String addText(int f1, int f2, int s1, int s2, String newText, char[][] codingTable) {
		newText += codingTable[f1][f2];
		newText += codingTable[s1][s2];
		return newText;
	}
}