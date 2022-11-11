package lotto;

import java.util.*;

public class Winning {
    private final String ERROR_MSG = "[ERROR] 잘못된 입력 입니다.";
    private final List<Integer> winning_numbers;
    private final int bonusNumber;

    public Winning(String winningNumberInput, String bonusNumberInput) {
        this.winning_numbers = transformWinningInput(winningNumberInput);
        this.bonusNumber = transformBonusInput(bonusNumberInput);
    }

    public List<Integer> getWinning_numbers() {
        return winning_numbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public List<Integer> transformWinningInput(String winningNumberInput) {
        validateWinningNumber(winningNumberInput);
        String[] inputs = winningNumberInput.split(",");

        List<Integer> winning = new ArrayList<>();
        Arrays.stream(inputs).mapToInt(Integer::parseInt).forEach(winning::add);
        return winning;
    }

    public int transformBonusInput(String bonusNumberInput) {
        validateBonusNumber(bonusNumberInput);
        return Integer.parseInt(bonusNumberInput);
    }


    public void validateWinningNumber(String winningNumberInput) {
        String[] inputs = winningNumberInput.split(",");
        for (String number : inputs) {
            validate(number);
        }

        if (inputs.length != 6) {
            throw new IllegalArgumentException(ERROR_MSG);
        }
    }

    public void validateBonusNumber(String bonusNumberInput) {
        validate(bonusNumberInput);
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
        if (this.winning_numbers.contains(intInput)) {
            throw new IllegalArgumentException(ERROR_MSG);
        }
    }
}
