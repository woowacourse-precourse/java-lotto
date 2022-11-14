package lotto.util;


import static lotto.util.Constant.MONEYUNIT;

public class Validator {
    public static void validatePayMoney(String payMoney) {
        if(Integer.parseInt(payMoney) % MONEYUNIT > 0){
            throw new IllegalArgumentException("잘못된 입력값입니다");
//            throw new IllegalArgumentException(Exception.WRONG_UNIT.getExceptionMessage());
        }
    }


}
