package lotto.exception;

public class InvalidRangeLottoNumberException extends IllegalArgumentException{
    private static final String ERROR_MESSAGE = "[ERROR] 로또 번호가 1 ~ 45 사이의 수가 아닙니다.";

    public InvalidRangeLottoNumberException() {
        super(ERROR_MESSAGE);
    }
}
