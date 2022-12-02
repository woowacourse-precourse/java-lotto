package lotto.util;

import java.util.regex.Pattern;

public class BudgetValidator implements Validator {
    private static final Pattern BUDGET_REGEX = Pattern.compile("^[0-9]*$");

    @Override
    public void validate(String input) throws IllegalArgumentException {
        String budget = removeSpace(input);
        validateNumber(budget);
        validateInputRange(budget);
        validateLottoRange(budget);
    }

    private void validateNumber(String budget) {
        if (!BUDGET_REGEX.matcher(budget).matches()) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_NUMERIC.getMessage());
        }
    }

    private void validateInputRange(String budget) {
        try {
            Integer.parseInt(budget);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_IN_RANGE_OF_INT.getMessage());
        }
    }

    private void validateLottoRange(String budget) {

    }

    private static String removeSpace(String input) {
        return input.replaceAll(" ", "");
    }
}
