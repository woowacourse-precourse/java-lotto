package lotto;

import java.util.List;
import java.util.regex.Pattern;

public class Exception {

	public void checkInputPrice(String input) throws IllegalArgumentException {
		if (!Pattern.matches("^[0-9]*$", input)) {
			throw new IllegalArgumentException(Constants.ERROR_NUMBER_PATTERN);
		}
	}
}
