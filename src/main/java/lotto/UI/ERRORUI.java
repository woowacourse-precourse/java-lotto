package lotto.UI;

import lotto.config.BaseException;

public class ERRORUI {

    //로또 발행 할때 중복이라든가 갯수 문제로 발행 실패
    public static void getErrorLotto(){
        System.out.println(BaseException.ERRORLOTTIO);
    }

    //로또 금액이 1000원으로 나누어떨어지지 않음
    public static void getErrorDivideValue(){
        System.out.println(BaseException.ERRORDIVIDE);
    }
}
