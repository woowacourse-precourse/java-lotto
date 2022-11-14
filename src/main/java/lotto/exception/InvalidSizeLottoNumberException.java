package lotto.exception;

public class InvalidSizeLottoNumberException  extends IllegalArgumentException{
    private static final String ERROR_MESSAGE = "[ERROR] 로또 번호의 개수가 6개가 아닙니다.";

    public InvalidSizeLottoNumberException() {
        super(ERROR_MESSAGE);
    }
}
