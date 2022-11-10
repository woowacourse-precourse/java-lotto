package lotto.exception;

import lotto.common.exception.BaseException;

public class IllegalMoneyException extends BaseException {
    final static String MSG = "올바르지 못한 돈입니다.";
    public IllegalMoneyException(){
        super(MSG);
    }
}
