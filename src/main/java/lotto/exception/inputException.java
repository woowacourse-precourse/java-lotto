package lotto.exception;

public class inputException extends IllegalArgumentException {

    public boolean notDigitExcept(String inputString) {
        for (char inputChar : inputString.toCharArray()) {
            if (!Character.isDigit(inputChar)) {
                throw new IllegalArgumentException();
            }
        }
        return false;
    }
}
