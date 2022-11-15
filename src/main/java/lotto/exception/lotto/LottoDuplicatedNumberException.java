package lotto.exception.lotto;

public class LottoDuplicatedNumberException extends IllegalArgumentException {
    private static final String EXCEPTION_MESSAGE_DUPLICATED_NUMBER = "[ERROR] 중복된 복권번호가 있습니다.";

    public LottoDuplicatedNumberException() {
        super(EXCEPTION_MESSAGE_DUPLICATED_NUMBER);
    }
}
