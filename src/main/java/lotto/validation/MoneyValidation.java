package lotto.validation;

public class MoneyValidation implements Validation{

    @Override
    public boolean validateInputIsInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
