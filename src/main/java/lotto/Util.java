package lotto;

public class Util {
	public static boolean isNotDigit(char source){
		return !Character.isDigit(source);
	}

	public static Long toLong(String number){
		return Long.parseLong(number);
	}
}
