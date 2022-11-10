package lotto.validation;

public class PlayerNumberValidation implements Validation{
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

}
