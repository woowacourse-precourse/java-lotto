package lotto.exception;

import lotto.common.exception.BaseException;

public class NotLottoValueException extends BaseException {
    final static String MSG = "로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    public NotLottoValueException(){
        super(MSG);
    }
}
