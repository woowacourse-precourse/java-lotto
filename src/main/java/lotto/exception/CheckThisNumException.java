package lotto.exception;

public class CheckThisNumException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 숫자를 입력해 주세요";

    public CheckThisNumException() {
        super(ERROR_MESSAGE);
        System.out.println(ERROR_MESSAGE);
    }
}
