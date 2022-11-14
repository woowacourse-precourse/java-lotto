package lotto.domain;

public class Judgment {
    private static final String NEGATIVE_INTEGER_ERROR_MESSAGE = "[ERROR] 로또 구입 금액은 양의 정수여야 합니다.";
    private static final String FAILED_TO_DIVIDE_BY_1000_ERROR_MESSAGE = "[ERROR] 로또 구입 금액은 1,000원 단위여야 합니다.";
    
    public int countLottos(int money) {
        
        if (money < 0) {
            throw new IllegalArgumentException(NEGATIVE_INTEGER_ERROR_MESSAGE);
        }
        
        if (((money % 1000) != 0) || (money < 1000)) {
            throw new IllegalArgumentException(FAILED_TO_DIVIDE_BY_1000_ERROR_MESSAGE);
        }
        
        return money/1000;
    }
    
}
