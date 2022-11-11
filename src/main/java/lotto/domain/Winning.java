package lotto.domain;

import java.util.*;

public class Winning {
    private final String ERROR_MSG = "[ERROR] 잘못된 입력 입니다.";
    private List<Integer> winningNumbers;
    private int bonusNumber;

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public void initWinningNumbers(String winningNumberInput) {
        this.winningNumbers = new ArrayList<>();
        String[] inputs = winningNumberInput.split(",");
        for (String input : inputs) {
            validate(input);
            this.winningNumbers.add(Integer.parseInt(input));
        }
        validateInputLength(this.winningNumbers);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void initBonusNumber(String bonusNumberInput) {
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

    public void validateInputLength(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException(ERROR_MSG);
        }
    }
}
