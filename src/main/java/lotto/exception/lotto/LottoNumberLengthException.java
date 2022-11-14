package lotto.exception.lotto;

public class LottoNumberLengthException extends IllegalArgumentException {
    private static final String EXCEPTION_MESSAGE_NUMBER_LENGTH = "[ERROR] 복권번호는 %d자리 숫자입니다.";

    public LottoNumberLengthException(int digit) {
        super(String.format(EXCEPTION_MESSAGE_NUMBER_LENGTH, digit));
    }
}
