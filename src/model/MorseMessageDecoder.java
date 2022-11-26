package model;
import java.io.FileNotFoundException;
import java.util.Iterator;


/**
 * @author Nathan DeBliek
 * @version 1.0
 * Last Modified: 2022-11-25 Added Java Doc
 * decodes messages from morse code
 */
public class MorseMessageDecoder
{
	MorseDecoder decoder;
	
	/**
	 * creates a new message decoder
	 */
	public MorseMessageDecoder() {
		try {
			decoder = new MorseDecoder("res\\codes.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * @param messageEncryped the encrypted message
	 * @return unencrypted message
	 * unencrypts the message
	 */
	public String decodeMessage(String messageEncryped) {
		String messageDecryped = "";
		String[] messageEncrypedChar = messageEncryped.split(" ");
		int counter = 0;
		for (String string : messageEncrypedChar) {
//			System.out.println("\"" + string + "\"");
			if (string.equals("")) {
				counter++;
				if(counter >= 6) {
					messageDecryped += " ";
				}
			} else {
				messageDecryped += decoder.decode(string);
				counter = 0;
			}
		}
		return messageDecryped;
	}
    
}