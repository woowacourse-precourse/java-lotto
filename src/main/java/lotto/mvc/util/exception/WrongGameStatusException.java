package lotto.mvc.util.exception;

import lotto.util.message.CommonMessageConst;

public class WrongGameStatusException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "%s 잘못된 LottoGameStatus 입니다.";

    public WrongGameStatusException() {
        super(String.format(DEFAULT_MESSAGE, CommonMessageConst.EXCEPTION_MESSAGE_PREFIX));
    }
}
