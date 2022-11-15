package lotto;

public class LottoAmount {
    private static final int LOTTO_MINIMUM_AMOUNT = 1000;
    private static final String LESS_THAN_THOUSAND_ERROR = "[ERROR] 최소 금액은 천원이며, 천 단위 숫자만 입력 가능합니다.";
    
    private final int purchaseAmount;

    public LottoAmount(int purchaseAmount) {
        checkMinimumAmount(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    public int makeLottoTickets() {
        return purchaseAmount / LOTTO_MINIMUM_AMOUNT;
    }

    private void checkMinimumAmount(int purchaseAmount) {
        if (purchaseAmount < LOTTO_MINIMUM_AMOUNT) {
            throw new IllegalArgumentException(LESS_THAN_THOUSAND_ERROR);
        }
    }

}
