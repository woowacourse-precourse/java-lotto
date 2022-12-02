package lotto.util;

public class BudgetValidator implements Validator {
    @Override
    public void validate(String input) throws IllegalArgumentException {
        String budget = removeSpace(input);
    }

    private static String removeSpace(String input) {
        return input.replaceAll(" ", "");
    }
}
