package lotto.validate;

import java.util.List;

public class Validator {
    private static final String ERROR_MESSAGE = "[ERROR] : ";
    private static final String MOD_IS_ZERO = "1,000원 단위로 ";
    private static final String OUT_OF_BOUND = "1~45 사이의 숫자를 입력해주세요";

    public static String generateErrorMessage(String input){
        return ERROR_MESSAGE + input;
    }
    public static void validateModIsZero(Integer purchaseAmount) {
        if((purchaseAmount % 1000) > 0){
            throw new IllegalArgumentException(generateErrorMessage(MOD_IS_ZERO));
        }
    }

    public static void validateOutOfBound(List<Integer> prizeNumbers) {
        for (Integer prizeNumber : prizeNumbers) {
            if(prizeNumber < 1 && prizeNumber > 45){
                throw new IllegalArgumentException(generateErrorMessage(OUT_OF_BOUND));
            }
        }
    }
}