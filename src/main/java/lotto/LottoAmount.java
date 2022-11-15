package lotto;

public class LottoAmount {
    private static final int LOTTO_MINIMUM_AMOUNT = 1000;
    private static final int ZERO = 0;
    private static final String LESS_THAN_THOUSAND_ERROR = "[ERROR] 최소 금액은 천원이며, 천 단위 숫자만 입력 가능합니다.";
    private static final String NOT_DIVISIBLE_BY_THOUSAND_ERROR = "[ERROR] 금액은 천원 단위로 입력해야 합니다.";

    private final int purchaseAmount;

    public LottoAmount(int purchaseAmount) {
        checkMinimumAmount(purchaseAmount);
        checkLottoAmount(purchaseAmount);
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

    private void checkLottoAmount(int purchaseAmount) {
        if (purchaseAmount % LOTTO_MINIMUM_AMOUNT != ZERO) {
            throw new IllegalArgumentException(NOT_DIVISIBLE_BY_THOUSAND_ERROR);
        }
    }
}
