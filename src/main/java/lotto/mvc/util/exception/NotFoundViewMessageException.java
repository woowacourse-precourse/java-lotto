package lotto.mvc.util.exception;

import lotto.util.message.CommonMessageConst;

public class NotFoundViewMessageException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "%s View 출력 메세지를 찾을 수 없습니다.";

    public NotFoundViewMessageException() {
        super(String.format(DEFAULT_MESSAGE, CommonMessageConst.EXCEPTION_MESSAGE_PREFIX));
    }
}
