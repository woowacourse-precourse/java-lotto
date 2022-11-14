package lotto;

public class Validation {

    public boolean isNumeric(String input) {
        if (input.matches("^[0-9]*$")) {
            return true;
        }
        return false;
    }

    public boolean isNumberInRange(int number) {
        if (number >= 1 && number <= 45) {
            return true;
        }
        return false;
    }

    public boolean isDividable(int number) {
        if (number % 1000 == 0) {
            return true;
        }
        return false;
    }

}
