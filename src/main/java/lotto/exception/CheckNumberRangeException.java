package lotto.exception;

public class CheckNumberRangeException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 1~45 사이의 값을 입력해주세요";

    public CheckNumberRangeException() {
        super(ERROR_MESSAGE);
        System.out.println("[ERROR] 숫자를 입력해 주세요");
    }
}
