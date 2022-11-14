package lotto;

public class Validation {

    public boolean isNumeric(String input) {
        if (input.matches("^[0-9]*$")) {
            return true;
        }
        return false;
    }

}
