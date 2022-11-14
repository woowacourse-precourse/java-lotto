package lotto.exception.view;

import lotto.exception.LottoException;

public class InputNotNumberException extends LottoException {
    private static final String INPUT_NOT_NUMBER_EXCEPTION_MESSAGE = "입력된 값 중 숫자가 아닌 값이 있습니다.";

    public InputNotNumberException() {
        super(INPUT_NOT_NUMBER_EXCEPTION_MESSAGE);
    }
}
