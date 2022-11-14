package lotto.exception;

public class InvalidLottoInputFormatException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 당첨 번호의 입력 형식이 맞지 않습니다.";

    public InvalidLottoInputFormatException() {
        super(ERROR_MESSAGE);
    }
}
