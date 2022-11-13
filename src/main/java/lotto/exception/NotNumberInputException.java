package lotto.exception;

import lotto.view.OutputView;

public class NotNumberInputException extends IllegalArgumentException {
    private static final String MESSAGE = "숫자가 아닌 입력입니다.";

    public NotNumberInputException() {
        super(MESSAGE);
    }
}
