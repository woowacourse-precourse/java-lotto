package lotto.domain;

import java.util.List;

public class BonusNumber {
    private int number;

    BonusNumber(String userInput, List<Integer> winningNumber) {
        int number = validate(userInput, winningNumber);
        this.number = number;
    }

    private int validate(String userInput, List<Integer> winningNumber) {
        Validator.numberFormatCheck(userInput);
        int number = Integer.parseInt(userInput);
        return number;
    }

    public int getNumber() {
        return number;
    }
}
