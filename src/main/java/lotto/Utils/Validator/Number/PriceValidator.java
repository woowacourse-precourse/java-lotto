package lotto.Utils.Validator.Number;

import lotto.Utils.Validator.IntegerValidator;
import lotto.Utils.Validator.ListValidator;
import lotto.View.OutputView;

public class PriceValidator {
    private static final String ERROR_MESSAGE="[ERROR] 금액이 올바르지 않습니다.";
    public static void price(int price) {
        if (price % 1000 != 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    public static void checkPrice(String price){
        if(!(checkPriceInteger(price) || (checkPriceCorrect(price)))){
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    public static boolean checkPriceInteger(String price){
        try {
            IntegerValidator.Integer(price);
            return true;
        }
        catch(Exception e){
            System.err.print(e);
            return false;
        }
    }

    public static boolean checkPriceCorrect(String price){
        try{
            price(Integer.parseInt(price));
            return true;
        }catch(Exception e){
            System.err.print(e);
            return false;
        }
    }
}
