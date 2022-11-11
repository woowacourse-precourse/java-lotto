package lotto.validate;

public class Validator {
    private static final String ERROR_MESSAGE = "[ERROR] : ";
    private static final String MOD_IS_ZERO = "1,000원 단위로 ";

    public static String generateErrorMessage(String input){
        return ERROR_MESSAGE + input;
    }
    public static int validateModIsZero(Integer purchaseAmount) {
        if((purchaseAmount % 1000) > 0){
            throw new IllegalArgumentException(generateErrorMessage(MOD_IS_ZERO));
        }
        return purchaseAmount / 1000;
    }
}