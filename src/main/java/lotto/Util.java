package lotto;

public class Util {

	public static int strToInt(String word) {
		try {
			return Integer.parseInt(word);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(Constants.ERROR_NOT_NUMBER_FORMAT);
		}
	}
}
