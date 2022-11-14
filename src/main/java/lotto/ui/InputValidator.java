package lotto.ui;

import java.util.List;

public class InputValidator {

    public void validateStringInputIsNumeric(String userInput) {
        for(char input : userInput.toCharArray()) {
            if(!Character.isDigit(input)) {
                throw new IllegalArgumentException();
            }
        }
    }

    public void validateListInputIsNumeric(List<String> userInput) {
        try {
            for(String input : userInput) {
                Integer.parseInt(input);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public void validateInputRange(List<String> userInput) {
        for(String input : userInput) {
            int inputNum = Integer.parseInt(input);

            if(inputNum < 1 || inputNum > 45) {
                throw new IllegalArgumentException();
            }
        }
    }

    public void validateListSize(List<String> userInput) {
        if(userInput.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public void validateInputMoney(String userInput) {
        validateStringInputIsNumeric(userInput);

        int money = Integer.parseInt(userInput);
        if(money%1000 != 0 || money < 1000) {
            throw new IllegalArgumentException();
        }
    }

    public void validateInputWinningNumber(List<String> userInput) {
        validateListInputIsNumeric(userInput);
        validateInputRange(userInput);
        validateListSize(userInput);

    }

    public void validateInputBonusNumber(String userInput, List<Integer> lottoNumbers) {
        validateStringInputIsNumeric(userInput);

        int inputNum = Integer.parseInt(userInput);

        if(lottoNumbers.contains(inputNum)) {
            throw new IllegalArgumentException(Messages.ERROR_BONUS_DUPLICATE.getMessage());
        }

        if(inputNum < 1 || inputNum > 45) {
            throw new IllegalArgumentException();
        }
    }
}
