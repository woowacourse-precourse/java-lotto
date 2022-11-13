package lotto.view.validation;

public class LottoValidation implements Validation{
    @Override
    public boolean validateInputIsInteger(String input) {
        String[] numbers = input.split(",");
        try {
            for (String number : numbers) {
                number = number.trim();
                Integer.parseInt(number);
            }
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean validateBonusNumber(String number) {
        try {
            Integer.parseInt(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
