package lotto.util;


import static java.lang.Integer.parseInt;

public class Validator {

    public static void validatePayMoney(String payMoney) {
        try {
            Double.parseDouble(payMoney);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_MONEY_UNIT.getErrorMessage());
        }
    }
}

//        if(Integer.parseInt(payMoney)%MONEY_UNIT > 0 && parseDouble(payMoney)%1 == 0){
//            throw new IllegalArgumentException(ErrorMessage.ERROR_INPUT_TYPE.getErrorMessage());
//        }
