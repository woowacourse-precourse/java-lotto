package lotto.exception;

public class InputException {
    private static final String PRICE_INTEGER_ERROR = "[ERROR] 구입금액은 숫자여야 합니다.";
    private static final String PRICE_IS_POSITIVE_NUMBER = "[ERROR] 시도 횟수는 1이상의 양수여야 합니다.";
    private static final String PRICE_UNIT_ERROR = "[ERROR] 구입금액은 1000원 단위입니다.";
    private static final int MIN_PRICE_NUMBER = 1;
    private static final int MIN_UNIT_NUMBER = 1000;


    public static int isValidInputPrice(String input){
        int price = validNumber(input);
        if (isUnitNumber(price) && isNaturalNumber(price)){
            return price;
        }
        throw new IllegalArgumentException();
    }

    private static int validNumber(String input){
        try{
            return Integer.parseInt(input);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(PRICE_INTEGER_ERROR);
        }
    }

    private static boolean isNaturalNumber(int price){
        if (price < MIN_PRICE_NUMBER){
            throw new IllegalArgumentException(PRICE_IS_POSITIVE_NUMBER);
        }
        return true;
    }

    private static boolean isUnitNumber(int price){
        if (price % MIN_UNIT_NUMBER != 0){
            throw new IllegalArgumentException(PRICE_UNIT_ERROR);
        }
        return true;
    }


}
