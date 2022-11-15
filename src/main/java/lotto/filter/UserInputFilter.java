package lotto.filter;

import static lotto.message.ErrorMessageConstants.*;
import static lotto.restrict.RestrictConstants.*;

import java.util.ArrayList;
import java.util.List;

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

	public List<Integer> splitStringToDelimiter(String userInputs, int size) {
		List<Integer> result = new ArrayList<>();

		checkUserInputDelimiterCount(userInputs, size);
		String[] splitUserInput = splitUserInputs(userInputs, size);
		for (String userInput : splitUserInput) {
			Long number = changeStringToLong(userInput);
			if (number == null) {
				throw new IllegalArgumentException(USER_INPUT_ERROR_MESSAGE);
			}
			result.add(number.intValue());
		}
		return result;
	}

	private void checkUserInputDelimiterCount(String userInputs, int size) {
		int delimiterCount = 0;

		for (int userInputsIndex = 0; userInputsIndex < userInputs.length(); userInputsIndex++) {
			String userInputsCharString = userInputs.substring(userInputsIndex, userInputsIndex + 1);

			if (userInputsCharString.equals(DELIMITER)) {
				delimiterCount += 1;
			}
		}
		if (delimiterCount != size - 1) {
			throw new IllegalArgumentException(USER_INPUT_ERROR_MESSAGE);
		}
	}

	private String[] splitUserInputs(String userInputs, int size) {
		if (userInputs == null) {
			throw new IllegalArgumentException(USER_INPUT_ERROR_MESSAGE);
		}
		String[] splitUserInput = userInputs.split(DELIMITER);
		if (splitUserInput.length != size) {
			throw new IllegalArgumentException(USER_INPUT_ERROR_MESSAGE);
		}
		return splitUserInput;
	}

	private void checkUserInputChar(char userInputChar) {
		if (userInputChar < '0' || '9' < userInputChar) {
			throw new IllegalArgumentException(USER_INPUT_ERROR_MESSAGE);
		}
	}
}
