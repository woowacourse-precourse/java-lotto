package lotto.exception;

import lotto.common.exception.BaseException;

public class IllegalLottoException extends BaseException {
    final static String MSG = "로또는 중복되지않은 6개여야합니다.";
    public IllegalLottoException(){
        super(MSG);
    }
}
