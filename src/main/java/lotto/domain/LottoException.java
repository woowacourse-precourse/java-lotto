package lotto.domain;

public class LottoException extends RuntimeException {
    private static final String MESSAGE = "[ERROR] 로또 오류 발생";

    public LottoException() {
        super(MESSAGE);
    }
}
