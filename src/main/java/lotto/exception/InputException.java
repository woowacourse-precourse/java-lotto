package lotto.exception;

public class InputException {
    private static final String PRICE_INTEGER_ERROR = "[ERROR] 구입금액은 숫자여야 합니다.";




    private static int validNumber(String input){
        try{
            return Integer.parseInt(input);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(PRICE_INTEGER_ERROR);
        }
    }

}
