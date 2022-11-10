package lotto.exception;

import lotto.common.exception.BaseException;

public class IllegalMoneyException extends BaseException {
    final static String MSG = "입력한 돈은 천단위의 자연수가아닙니다.";
    public IllegalMoneyException(){
        super(MSG);
    }
}
