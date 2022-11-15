package lotto.exception;

public class DuplicateLottoNumberException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 번호가 중복되는 로또 번호가 존재합니다.";

    public DuplicateLottoNumberException() {
        super(ERROR_MESSAGE);
    }
}
