package lotto.ui;

import java.util.List;

public class InputValidator {

    public void validateStringInputIsNumeric(String userInput) {
        for (char input : userInput.toCharArray()) {
            if (!Character.isDigit(input)) {
                throw new IllegalArgumentException(Messages.ERROR_NUMERIC.getMessage());
            }
        }
    }

    public void validateListInputIsNumeric(List<String> userInput) {
        try {
            for (String input : userInput) {
                Integer.parseInt(input);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Messages.ERROR_LIST_NUMERIC.getMessage());
        }
    }

    public void validateInputRange(List<String> userInput) {
        for (String input : userInput) {
            int inputNum = Integer.parseInt(input);

            if (inputNum < 1 || inputNum > 45) {
                throw new IllegalArgumentException(Messages.ERROR_LOTTO_NUMBER_RANGE.getMessage());
            }
        }
    }

    public void validateInputSize(List<String> userInput) {
        if (userInput.size() != 6) {
            throw new IllegalArgumentException(Messages.ERROR_LOTTO_SIZE.getMessage());
        }
    }

    public void validateInputMoney(String userInput) {
        validateStringInputIsNumeric(userInput);

        int money = Integer.parseInt(userInput);

        if (money % 1000 != 0) {
            throw new IllegalArgumentException(Messages.ERROR_MONEY_UNIT.getMessage());
        }

        if (money < 1000) {
            throw new IllegalArgumentException(Messages.ERROR_MONEY_MIN.getMessage());
        }
    }

    public void validateInputWinningNumber(List<String> userInput) {
        validateListInputIsNumeric(userInput);
        validateInputRange(userInput);
        validateInputSize(userInput);

    }

    public void validateInputBonusNumber(String userInput, List<Integer> lottoNumbers) {
        validateStringInputIsNumeric(userInput);

        int inputNum = Integer.parseInt(userInput);

        if (lottoNumbers.contains(inputNum)) {
            throw new IllegalArgumentException(Messages.ERROR_BONUS_DUPLICATE.getMessage());
        }

        if (inputNum < 1 || inputNum > 45) {
            throw new IllegalArgumentException();
        }
    }
}
