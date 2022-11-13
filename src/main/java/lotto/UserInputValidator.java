package lotto;

import java.util.List;

public class UserInputValidator {

    public void validateAmountInput(String input) {
        if (!isInteger(input)) {
            throw new IllegalArgumentException(GameConstant.TYPE_EXCEPTION.getValue());
        }

        if (isDivisible(input)) {
            throw new IllegalArgumentException(GameConstant.DIVISIBLE_EXCEPTION.getValue());
        }
    }

    public void validateWinningNumber(List<String> numbers) {
        for (String element : numbers) {
            if (!isInteger(element)) {
                throw new IllegalArgumentException(GameConstant.TYPE_EXCEPTION.getValue());
            }

            if (checkBoundary(element)) {
                throw new IllegalArgumentException(GameConstant.BOUNDARY_EXCEPTION.getValue());
            }
        }
    }

    public void validateBonusNumber(String number) {
        if (!isInteger(number)) {
            throw new IllegalArgumentException(GameConstant.TYPE_EXCEPTION.getValue());
        }

        if (checkBoundary(number)) {
            throw new IllegalArgumentException(GameConstant.BOUNDARY_EXCEPTION.getValue());
        }
    }

    public boolean checkBoundary(String input) {
        return Integer.parseInt(input) < 1 || Integer.parseInt(input) > 45;
    }

    public boolean isDivisible(String input) {
        return (Integer.parseInt(input) % 1000 != 0);
    }

    public boolean isInteger(String input) {
        return input.matches("[0-9.]+");
    }
}
