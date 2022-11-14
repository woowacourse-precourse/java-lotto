package lotto.domain;

public class Judgment {
    private static final String NEGATIVE_INTEGER_ERROR_MESSAGE = "[ERROR] 로또 구입 금액은 양의 정수여야 합니다.";
    private static final String FAILED_TO_DIVIDE_BY_1000_ERROR_MESSAGE = "[ERROR] 로또 구입 금액은 1,000원 단위여야 합니다.";
    private static final String NO_5_COMMAS_ERROR_MESSAGE = "[ERROR] 당첨 번호는 , 다섯 개로 구성되어야 합니다.";
    private static final String OUT_OF_BOUNDS_ERROR_MESSAGE = "[ERROR] 유효한 숫자 범위를 벗어났습니다.";
    
    public int countLottos(int money) {
        
        if (money < 0) {
            throw new IllegalArgumentException(NEGATIVE_INTEGER_ERROR_MESSAGE);
        }
        
        if (((money % 1000) != 0) || (money < 1000)) {
            throw new IllegalArgumentException(FAILED_TO_DIVIDE_BY_1000_ERROR_MESSAGE);
        }
        
        return money/1000;
    }
    
    public void check5Commas(String input) {
        int commaCount = 0;
        
        for (int index = 0; index < input.length(); index++) {
            if (',' == input.charAt(index)) {
                commaCount++;
            }
        }
        
        if (commaCount != 5) {
            throw new IllegalArgumentException(NO_5_COMMAS_ERROR_MESSAGE);
        }
    }
    
    public void checkRange(int number, int fromNumber, int toNumber) {
        if (number < fromNumber) {
            throw new IllegalArgumentException(OUT_OF_BOUNDS_ERROR_MESSAGE);
        }
        
        if (toNumber < number) {
            throw new IllegalArgumentException(OUT_OF_BOUNDS_ERROR_MESSAGE);
        }
    }
}
