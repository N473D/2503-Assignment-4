package model;
import java.io.FileNotFoundException;
import java.util.Iterator;


public class MorseMessageDecoder
{
	MorseDecoder decoder;
	
	public MorseMessageDecoder() {
		try {
			decoder = new MorseDecoder("res\\codes.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
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