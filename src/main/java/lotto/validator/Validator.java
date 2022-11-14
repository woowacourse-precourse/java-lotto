package lotto.validator;

import lotto.model.enums.GameMessage;

public class Validator {
    public static void validateInteger(String userInput) {
        for (int index = 0; index < userInput.length(); index++) {
            if (!Character.isDigit(userInput.charAt(index))) {
                throw new IllegalArgumentException(ErrorMessage.INTEGER_ERROR_MESSAGE.getMessage());
            }
        }
    }
}
