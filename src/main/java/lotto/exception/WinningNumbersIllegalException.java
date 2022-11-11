package lotto.exception;

public class WinningNumbersIllegalException extends IllegalArgumentException {
    private static final String message = "당첨번호가 입력 표준에 맞지 않습니다.";

    public WinningNumbersIllegalException() {
        super(message);
    }
}
