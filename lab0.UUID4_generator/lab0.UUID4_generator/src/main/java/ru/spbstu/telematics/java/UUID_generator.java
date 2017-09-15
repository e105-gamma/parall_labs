package ru.spbstu.telematics.java;
import java.security.SecureRandom;


public class UUID_generator 
{
    public  String generateUUID()
    {

		SecureRandom rand = new SecureRandom();
		StringBuffer s = new StringBuffer();
		String hexDigits = "0123456789abcdef";
		for(int i=0;i<36;i++) {
			s.append(hexDigits.charAt(rand.nextInt(hexDigits.length())));
		}
    	s.setCharAt(14,'4');
    	s.setCharAt(19, Character.forDigit(((s.charAt(19)-'0' & 0x3) | 0x8),16));
    	for(int i=8;i<=23;i=i+5) {
    		s.setCharAt(i,'-');
    	}
    	System.out.println(s);
    	return s.toString();
    	   
    }
}
