package lotto.exception;

public class ExceptionHandler {

    public void noNumberException(String input) throws IllegalArgumentException {
        for (int index = 0; index < input.length(); index++) {
            if (input.charAt(index) < '0' || '9' < input.charAt(index)) {
                throw new IllegalArgumentException("[ERROR] 입력값이 숫자가 아닙니다.");
            }
        }
    }

}
