package lotto.exception;

public class BallSizeOutOfRangeException extends IllegalArgumentException {
    private static final String MESSAGE = "로또 번호는 중복될 수 없습니다.";

    public BallSizeOutOfRangeException() {
        super(MESSAGE);
    }
}
