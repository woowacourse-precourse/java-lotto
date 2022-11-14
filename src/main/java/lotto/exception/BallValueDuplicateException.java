package lotto.exception;

public class BallValueDuplicateException extends IllegalArgumentException {
    private static final String MESSAGE = "로또 번호는 중복될 수 없습니다.";

    public BallValueDuplicateException() {
        super(MESSAGE);
    }
}
