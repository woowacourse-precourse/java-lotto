package lotto;

import java.util.*;

public class Winning {
    private final String ERROR_MSG = "[ERROR] 잘못된 입력 입니다.";

    private List<Integer> winningNumbers = new ArrayList<>();
    private int bonusNumber = 0;

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void initializeWinningNumber(String winningNumberInput) {
        String[] inputs = winningNumberInput.split(",");
        for (String number : inputs) {
            validate(number);
            this.winningNumbers.add(Integer.parseInt(number));
        }

        if (this.winningNumbers.size() != 6) {
            throw new IllegalArgumentException(ERROR_MSG);
        }
    }

    public void initializeBonusNumber(String bonusNumberInput) {
        validate(bonusNumberInput);
        this.bonusNumber = Integer.parseInt(bonusNumberInput);
    }


    public void validate(String input) {
        validateStringToInteger(input);
        validateRange(input);
        validateUniqueNumber(input);
    }

    public void validateStringToInteger(String input) {
        try {
            Integer.parseInt(input);
        }catch (Exception e) {
            throw new IllegalArgumentException(ERROR_MSG);
        }
    }

    public void validateRange(String input) {
        int intInput = Integer.parseInt(input);
        if (intInput < 1 || intInput > 45) {
            throw new IllegalArgumentException(ERROR_MSG);
        }
    }

    public void validateUniqueNumber(String input) {
        int intInput = Integer.parseInt(input);
        if (this.winningNumbers.contains(intInput)) {
            throw new IllegalArgumentException(ERROR_MSG);
        }
    }
}
