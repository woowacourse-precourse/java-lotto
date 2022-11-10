package lotto.exception;

public class InputException extends IllegalArgumentException {

    public boolean notDigitException(String inputString) {
        if(inputString.chars().allMatch(Character::isDigit)) {
            return true;
        }
        throw new IllegalArgumentException();
    }
}
