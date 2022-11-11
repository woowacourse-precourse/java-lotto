package lotto.exception;

public class InputException {
    private static final String PRICE_INTEGER_ERROR = "[ERROR] 구입금액은 숫자여야 합니다.";
    private static final String PRICE_IS_POSITIVE_NUMBER = "[ERROR] 시도 횟수는 1이상의 양수여야 합니다.";
    private static final int MIN_PRICE_NUMBER = 1;



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

}
