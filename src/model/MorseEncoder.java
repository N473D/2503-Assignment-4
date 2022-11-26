package model;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Creates the morse code array and encodes the letters
 * @author Gabriel Avinante
 * @version 1.0
 * Last Modified: Nov 25, 2022, created javadoc, Gabriel Avinante
 */
public class MorseEncoder {
	String[] alphabet;

	/**
	 * Initializes the string array list and creates the array of morse code
	 * @param fileName The file that contains the morse code
	 * @throws FileNotFoundException
	 */
	public MorseEncoder(String fileName) throws FileNotFoundException {
		alphabet = new String[26];
		createArray(fileName);

	}

	/**
	 * Reads the file and creates the array of morse code
	 * @param fileName The file that contains the morse code
	 * @throws FileNotFoundException
	 */
	private void createArray(String fileName) throws FileNotFoundException {
		Scanner in = new Scanner(new File(fileName));
		String letter;
		String code;
		while (in.hasNextLine()) {
			letter = in.next();
			code = in.next();
			alphabet[letter.charAt(0) - 'A'] = code;
		}
		in.close();
	}

	/**
	 * Encodes the message inputed by the user
	 * @param message The message from the user 
	 * @return The morse code of the letter from the message
	 */
	public String encode(String message) {

		String code = null;
		switch (message) {
		case "a":
			code = alphabet[0];
			break;
		case "b":
			code = alphabet[1];
			break;
		case "c":
			code = alphabet[2];
			break;
		case "d":
			code = alphabet[3];
			break;
		case "e":
			code = alphabet[4];
			break;
		case "f":
			code = alphabet[5];
			break;
		case "g":
			code = alphabet[6];
			break;
		case "h":
			code = alphabet[7];
			break;
		case "i":
			code = alphabet[8];
			break;
		case "j":
			code = alphabet[9];
			break;
		case "k":
			code = alphabet[10];
			break;
		case "l":
			code = alphabet[11];
			break;
		case "m":
			code = alphabet[12];
			break;
		case "n":
			code = alphabet[13];
			break;
		case "o":
			code = alphabet[14];
			break;
		case "p":
			code = alphabet[15];
			break;
		case "q":
			code = alphabet[16];
			break;
		case "r":
			code = alphabet[17];
			break;
		case "s":
			code = alphabet[18];
			break;
		case "t":
			code = alphabet[19];
			break;
		case "u":
			code = alphabet[20];
			break;
		case "v":
			code = alphabet[21];
			break;
		case "w":
			code = alphabet[22];
			break;
		case "x":
			code = alphabet[23];
			break;
		case "y":
			code = alphabet[24];
			break;
		case "z":
			code = alphabet[25];
			break;
		}
		return code;
	}
}
