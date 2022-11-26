package model;
import java.io.FileNotFoundException;

/**
 * Uses the MorseEncoder class to encode the full message of the user
 * @author Gabriel Avinante
 *
 */
public class MorseMessageEncoder {
	
	MorseEncoder encoder;
	
	/**
	 * Uses the text file for the encoder
	 */
	public MorseMessageEncoder() {
		try {
			encoder = new MorseEncoder("res\\codes.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Encodes the full message of the user
	 * @param message The message that the user had inputed
	 * @return The full encrypted message in morse code
	 */
	public String encodeMessage(String message) {
		message = message.toLowerCase();
		String messageEncrypted = "";
		String[] messageEncrypedChar = message.split("");
		for (String string : messageEncrypedChar) {
			if (string.equals(" ")) {
				messageEncrypted += "       ";
			} else {
				messageEncrypted += encoder.encode(string);
				messageEncrypted += "   ";
			}
		}
		return messageEncrypted;
	}
    
}