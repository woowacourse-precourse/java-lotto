package lotto.domain;

import lotto.view.Message;

import java.util.Arrays;
import java.util.List;

public class User {

    private String changeWord;

    public User() {
    }

    public User(String changeWord) {
        this.changeWord = changeWord;
    }

    public void validateUserMoney(String userInput) {
        validateNotNull(userInput);
        validateNotZero(userInput);
        validateNoSpace(userInput);
        validateNumber(userInput);
        validateNoChange(Long.parseLong(userInput));
    }

    public void validateUserWinningNumber(String userInput) {
        validateNotNull(userInput);
        validateNoSpace(userInput);
        validateHasComma(userInput);
        validateNumberList(userInput);
    }

    public void validateUserBonusNumber(String userInput, List<Integer> winningNumbers) {
        validateNotNull(userInput);
        validateNotZero(userInput);
        validateNoSpace(userInput);
        validateNumber(userInput);
        validateRange(Integer.parseInt(userInput));
        validateDuplicate(Integer.parseInt(userInput), winningNumbers);
    }


    private void validateNotNull(String userInput) {
        if (userInput == null || userInput == "") {
            throw new IllegalArgumentException(changeWord + Message.ISNULL);
        }
    }

    private void validateNotZero(String userInput) {
        if ("0".equals(userInput)) {
            throw new IllegalArgumentException(changeWord + Message.ISZERO);
        }
    }

    private void validateNoSpace(String userInput) {
        if (userInput != userInput.trim() || userInput.indexOf(" ") != -1) {
            throw new IllegalArgumentException(changeWord + Message.ISSPACE);
        }
    }

    private void validateNumber(String userInput) {
        try {
            Long.parseLong(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(changeWord + Message.NOTNUMBER);
        }
    }

    private void validateNoChange(long userMoney) {
        if (userMoney % Resource.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(changeWord + Message.HASCHARGE);
        }
    }

    private void validateHasComma(String userInput) {
        if (userInput.indexOf(Resource.SEPARATOR) == -1) {
            throw new IllegalArgumentException(changeWord + Message.NOCOMMA);
        }
    }

    private void validateNumberList(String userInput) {
        List<String> userInputs = Arrays.asList(userInput.split(Resource.SEPARATOR));
        for (String userNumber : userInputs) {
            validateNumber(userNumber);
        }
    }

    private void validateRange(long userInput) {
        if (userInput < Resource.MIN_LOTTO_NUMBER || userInput > Resource.MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(changeWord + Message.NOTRANGE);
        }
    }

    private void validateDuplicate(long userInput, List<Integer> winningNumbers) {
        if (winningNumbers.contains(userInput)) {
            throw new IllegalArgumentException(changeWord + Message.ISDUPLICATE);
        }
    }


}
