package lotto.exception.view;

import lotto.exception.LottoException;

public class InputNotContainRestException extends LottoException {
    private static final String INPUT_NOT_CONTAIN_REST_EXCEPTION_MESSAGE = "입력 값에 쉽표가 없습니다.";

    public InputNotContainRestException() {
        super(INPUT_NOT_CONTAIN_REST_EXCEPTION_MESSAGE);
    }
}
