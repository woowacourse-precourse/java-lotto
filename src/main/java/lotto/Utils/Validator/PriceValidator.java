package lotto.Utils.Validator;



public class PriceValidator {
    private static final String ERROR_MESSAGE="[ERROR] 금액이 올바르지 않습니다.";


    public static boolean checkPriceInteger(String price){
        try {
            IntegerValidator.Integer(price);
            return true;
        }
        catch(IllegalArgumentException e){
            System.err.println(e);
            return false;
        }
    }

    public static boolean priceCorrect(int price) {
        if (price % 1000 != 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
        return true;
    }
}
