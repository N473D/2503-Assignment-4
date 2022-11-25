package model;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;

public class MorseDecoder
{
	BinaryTree<Character> morseCode;

	public MorseDecoder(String fileName) throws FileNotFoundException {
		morseCode = new BinaryTree<Character>(null);
		createTree(fileName);
	}

	private void createTree(String fileName) throws FileNotFoundException {
		Scanner in = new Scanner(new File(fileName));
		String letter;
		String code;
		while (in.hasNextLine()) {
			letter = in.next();
			code = in.next();
			placeCode(morseCode, letter.charAt(0), code);
		}
		in.close();
	}

	private void placeCode(BinaryTree<Character> m, char charToPlace, String encryption) {

		if (encryption.equals(".")) {
			m.setLeft(new BinaryTree<Character>(charToPlace));
		} else if (encryption.equals("-")) {
			m.setRight(new BinaryTree<Character>(charToPlace));
		} else {
			BinaryTree<Character> temp = m;
			if (encryption.charAt(0) == '.') {
				temp = temp.getLeft();
			} else {
				temp = temp.getRight();
			}
			placeCode(temp, charToPlace, encryption.substring(1));
		}
	}

	public void print() {
		Iterator<Character> it = morseCode.iterator();

		while (it.hasNext())
			System.out.print(it.next() + " ");
	}

	public char decode(String encryption) {
		return decoder(morseCode, encryption);
	}

	private char decoder(BinaryTree<Character> m, String encryption) {
		if (encryption.equals(".")) {
			return m.getLeft().getRootElement();
		} else if (encryption.equals("-")) {
			return m.getRight().getRootElement();
		} else {
			BinaryTree<Character> temp = m;
			if (encryption.charAt(0) == '.') {
				temp = temp.getLeft();
			} else {
				temp = temp.getRight();
			}
			return decoder(temp, encryption.substring(1));
		}
	}
}