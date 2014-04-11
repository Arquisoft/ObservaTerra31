package utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hashin {

	/**
	 * Codigo extraido de http://www.mkyong.com/java/java-md5-hashing-example/
	 * 
	 * @param password
	 * @return
	 */
	public static String md5(String password) {
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
			md.update(password.getBytes());

			byte byteData[] = md.digest();

			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < byteData.length; i++)
				sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16)
						.substring(1));
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			return null;
		}
	}

}
