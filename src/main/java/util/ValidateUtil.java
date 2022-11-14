package util;

import java.util.regex.Pattern;

public class ValidateUtil {
	
	public static boolean isNumber(String inputValue){
		return Pattern.matches("^[0-9]*$", inputValue);
	}

	public static boolean isMultipleOf1000(String inputValue) {
		return Integer.parseInt(inputValue)%1000 == 0;
	}
}
