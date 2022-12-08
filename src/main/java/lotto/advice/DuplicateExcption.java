package lotto.advice;

public class DuplicateExcption extends IllegalArgumentException {
    public DuplicateExcption(String message) {
        super(message);
    }
}
