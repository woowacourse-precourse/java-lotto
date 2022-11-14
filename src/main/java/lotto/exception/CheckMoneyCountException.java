package lotto.exception;

public class CheckMoneyCountException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 1000원 단위의 숫자를 입력해 주세요";

    public CheckMoneyCountException() {
        super(ERROR_MESSAGE);
        System.out.println(ERROR_MESSAGE);
    }
}
