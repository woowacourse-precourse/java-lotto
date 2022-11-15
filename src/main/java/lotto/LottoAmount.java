package lotto;

public class LottoAmount {
    private static final int LOTTO_MINIMUM_AMOUNT = 1000;

    private final int purchaseAmount;

    public LottoAmount(int purchaseAmount) {

        this.purchaseAmount = purchaseAmount;
    }

    public int makeLottoTickets() {
        return purchaseAmount / LOTTO_MINIMUM_AMOUNT;
    }


}
