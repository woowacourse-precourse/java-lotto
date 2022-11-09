package lotto.validation;

import java.util.List;

public class Validation {

    public void validateMoneyInput(String input) {
        validateStringIsNumeric(input);
        validateDivideThousand(Integer.parseInt(input));
    }

    public void validateWinNumberInput(String input) {
        String[] token = input.split(",");
        if (token.length != 6) {
            throw new IllegalArgumentException();
        }

        for (String s : token) {
            validateStringIsNumeric(s);
        }

        for (String s : token) {
            int num = Integer.parseInt(s);
            validateNumberInBound(1, 45, num);
        }
    }

    public void validateBonusNumberInput(List<Integer> winNumbers, String bonusNumber) {
        validateStringIsNumeric(bonusNumber);
        int bonus = Integer.parseInt(bonusNumber);
        checkBonusNumberAlreadyPicked(winNumbers, bonus);
        validateNumberInBound(1, 45, bonus);
    }

    private void checkBonusNumberAlreadyPicked(List<Integer> winNumbers, int bonus) {
        if (winNumbers.contains(bonus)) {
            throw new IllegalArgumentException();
        }
    }


    private void validateStringIsNumeric(String string) {
        try {
            Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNumberInBound(int min, int max, int input) {
        if (input < min) {
            throw new IllegalArgumentException();
        }
        if (input > max) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDivideThousand(int money) {
        if (money < 1000) {
            throw new IllegalArgumentException();
        }
        if (money % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }
}
