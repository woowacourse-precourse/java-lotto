package lotto.exception;

public class InvalidLottoInputFormatException extends IllegalArgumentException{
    private static final String ERROR_MESSAGE = "[ERROR] 입력 형식에 맞지 않은 당첨 번호가 입니다.";

    public InvalidLottoInputFormatException() {
        super(ERROR_MESSAGE);
    }
}
