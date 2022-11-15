package lotto.validate;

public class validateNumber {
    private static final String NOT_NUMERIC_MESSAGE = "[ERROR] 구매 금액은 숫자여야 합니다.";
    private static final String UNDER_1000_MESSAGE = "[ERROR] 구매 금액은 1000원 이상이어야 합니다.";
    private static final String NOT_1000_UNIT_MESSAGE = "[ERROR] 구매 금액은 1000원 단위여야 합니다.";
    private static final Integer STANDARD_MONEY = 1000;

    private void isUnderStandardMoney(Integer purchaseMoney) {
        if( purchaseMoney < 1000 ) {
            throw new IllegalArgumentException(UNDER_1000_MESSAGE);
        }
        return;
    }
}
