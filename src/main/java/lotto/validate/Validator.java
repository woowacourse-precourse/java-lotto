package lotto.validate;

import java.util.List;

public class Validator {
    private static final String ERROR_MESSAGE = "[ERROR] : ";
    private static final String MOD_IS_ZERO = "1,000원 단위로 입력해주세요";
    private static final String OUT_OF_BOUND = "1~45 사이의 숫자를 입력해주세요";
    private static final String OUT_OF_SIZE = "6개의 데이터만 입력해주세요";
    private static final String DUPLICATED_MESSAGE = "중복된 데이터가 입력됐습니다";
    private static final Integer DEFAULT_MINIMUM_NUMBER = 1;
    private static final Integer DEFAULT_MAXIMUM_NUMBER = 45;

    public static String generateErrorMessage(String input){
        return ERROR_MESSAGE + input;
    }
    public static void validateModIsZero(Integer purchaseAmount) {
        if((purchaseAmount % 1000) > 0){
            throw new IllegalArgumentException(generateErrorMessage(MOD_IS_ZERO));
        }
    }

    public static void validateOutOfBoundList(List<Integer> prizeNumbers) {
        for (Integer prizeNumber : prizeNumbers) {
            if(prizeNumber < DEFAULT_MINIMUM_NUMBER && prizeNumber > DEFAULT_MAXIMUM_NUMBER){
                throw new IllegalArgumentException(generateErrorMessage(OUT_OF_BOUND));
            }
        }
    }
    public static void validateOutOfBound(Integer number){
        if(number < DEFAULT_MINIMUM_NUMBER && number > DEFAULT_MAXIMUM_NUMBER){
            throw new IllegalArgumentException(generateErrorMessage(OUT_OF_BOUND));
        }
    }

    public static void validateOutOfSize(List<Integer> prizeNumbers) {
        if(prizeNumbers.size()>6){
            throw new IllegalArgumentException(generateErrorMessage(OUT_OF_SIZE));
        }
    }

    public static void validateDuplicateData(List<Integer> prizeNumbers) {
        if(prizeNumbers.size() != prizeNumbers.stream().distinct().count()){
            throw new IllegalArgumentException(generateErrorMessage(DUPLICATED_MESSAGE));
        }
    }
}