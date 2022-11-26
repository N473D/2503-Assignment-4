package model;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;

/**
 * @author Nathan DeBliek
 * @version 1.0
 * Last Modified: 2022-11-25 Added Java Doc
 * used for translating characters from morse code
 */
public class MorseDecoder
{
	BinaryTree<Character> morseCode;

	/**
	 * @param fileName the code file
	 * @throws FileNotFoundException can't find code file
	 * constructs a new morse decoder and initializes the tree
	 */
	public MorseDecoder(String fileName) throws FileNotFoundException {
		morseCode = new BinaryTree<Character>(null);
		createTree(fileName);
	}

	/**
	 * @param fileName fileName the code file
	 * @throws FileNotFoundException can't find code file
	 * creates a new tree for later decoding
	 */
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

	/**
	 * @param m current tree
	 * @param charToPlace character being placed
	 * @param encryption encryption string
	 * places new characters in the code tree
	 */
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

	/**
	 * prints the code tree
	 */
	public void print() {
		Iterator<Character> it = morseCode.iterator();

		while (it.hasNext())
			System.out.print(it.next() + " ");
	}

	public char decode(String encryption) {
		return decoder(morseCode, encryption);
	}

	/**
	 * @param m current tree
	 * @param encryption encrypted character
	 * decodes the encrypted character
	 */
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