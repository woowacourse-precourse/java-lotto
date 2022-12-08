package lotto.util.validator;

import static lotto.util.Constants.LOTTO_PRICE;

import lotto.util.ExceptionMessage;

public class BudgetValidator extends Validator {

    @Override
    public void validate(String input) throws IllegalArgumentException {
        String budget = removeSpace(input);
        validateNumeric(budget);
        validateRange(budget);
        validateInputUnit(budget);
    }


    private void validateInputUnit(String budget) {
        if (Integer.parseInt(budget) % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_UNIT_OF_BUDGET.getMessage());
        }
    }

}
