package lotto.domain;

/**
 * 구매한 금액의 유효성과 관련 기능을 책임지는 클래스
 */
public class PurchaseAmount {

    private final int UNIT_PRICE = 1000;

    private final String ERROR_INDIVISIBLE = "[ERROR] 1000원으로 나누어떨어지는 금액만 입력해주십시오.";

    public PurchaseAmount() {
    }

    private void isValidateDivisible(int purchaseAmount) {
        if(purchaseAmount % UNIT_PRICE != 0){
            throw new IllegalArgumentException(ERROR_INDIVISIBLE);
        }
    }
}
