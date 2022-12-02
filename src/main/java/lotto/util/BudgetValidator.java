package lotto.util;

import static lotto.util.Constants.LOTTO_PRICE;

import java.util.regex.Pattern;

public class BudgetValidator implements Validator {
    private static final Pattern BUDGET_REGEX = Pattern.compile("^[0-9]*$");

    @Override
    public void validate(String input) throws IllegalArgumentException {
        String budget = removeSpace(input);
        validateNumber(budget);
        validateInputRange(budget);
        validateInputUnit(budget);
    }

    private void validateNumber(String budget) {
        if (!BUDGET_REGEX.matcher(budget).matches()) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NOT_NUMERIC.getMessage());
        }
    }

    private void validateInputRange(String budget) {
        try {
            Integer.parseInt(budget);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_OUT_OF_INT_RANGE.getMessage());
        }
    }

    private void validateInputUnit(String budget) {
        if (Integer.parseInt(budget) % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_UNIT_OF_BUDGET.getMessage());
        }
    }

    private static String removeSpace(String input) {
        return input.replaceAll(" ", "");
    }
}
