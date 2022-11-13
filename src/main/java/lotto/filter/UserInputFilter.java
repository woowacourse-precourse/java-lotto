package lotto.filter;

import static lotto.message.ErrorMessageConstants.*;

public class UserInputFilter {

	public Long changeStringToLong(String userInput) {
		long result = 0;

		if (userInput == null) {
			throw new IllegalArgumentException(USER_INPUT_ERROR_MESSAGE);
		}
		for (int userInputIndex = 0; userInputIndex < userInput.length(); userInputIndex++) {
			char userInputChar = userInput.charAt(userInputIndex);
			checkUserInputChar(userInputChar);
			result *= 10;
			result += userInputChar - '0';
		}
		return result;
	}

	private void checkUserInputChar(char userInputChar) {
		if (userInputChar < '0' || '9' < userInputChar) {
			throw new IllegalArgumentException(USER_INPUT_ERROR_MESSAGE);
		}
	}
}
