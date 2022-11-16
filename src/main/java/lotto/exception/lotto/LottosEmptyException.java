package lotto.exception.lotto;

public class LottosEmptyException extends IllegalArgumentException{

    private static final String ERROR_MESSAGE = "[ERROR] 1개 이상의 로또가 포함되어 있어야합니다.";

    public LottosEmptyException() {
        super(ERROR_MESSAGE);
    }
}
