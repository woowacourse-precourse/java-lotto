package lotto;

public class LottoAmount {
    private static final int ZERO = 0;
    private static final int LOTTO_MINIMUM_AMOUNT = 1000;
    private static final String AMOUNT_UNIT_ERROR = "[ERROR] " + LOTTO_MINIMUM_AMOUNT + "원 단위로 입력하세요.";
    private static final String LOTTO_MINIMUM_AMOUNT_ERROR = "[ERROR] 최소금액은" + LOTTO_MINIMUM_AMOUNT + "원 입니다.";

    private final int purchaseAmount;

    public LottoAmount(int purchaseAmount) {
        checkMinimumAmount(purchaseAmount);
        checkLottoAmount(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    public int makeLottoTickets() {
        return purchaseAmount / LOTTO_MINIMUM_AMOUNT;
    }

    private void checkLottoAmount(int purchaseAmount) {
        if (purchaseAmount % LOTTO_MINIMUM_AMOUNT != ZERO) {
            throw new IllegalArgumentException(AMOUNT_UNIT_ERROR);
        }
    }

    private void checkMinimumAmount(int purchaseAmount) {
        if (purchaseAmount < LOTTO_MINIMUM_AMOUNT) {
            throw new IllegalArgumentException(LOTTO_MINIMUM_AMOUNT_ERROR);
        }
    }
}
