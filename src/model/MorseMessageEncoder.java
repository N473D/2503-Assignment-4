package model;
import java.io.FileNotFoundException;


public class MorseMessageEncoder {
	
	MorseEncoder encoder;
	public MorseMessageEncoder() {
		try {
			encoder = new MorseEncoder("res\\codes.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	public String encodeMessage(String message) {
		message = message.toLowerCase();
		String messageEncrypted = "";
		String[] messageEncrypedChar = message.split("");
		for (String string : messageEncrypedChar) {
			if (string.equals(" ")) {
				messageEncrypted += "       ";
			} else {
				messageEncrypted += encoder.encoder(string);
				messageEncrypted += "   ";
			}
		}
		return messageEncrypted;
	}
    
}