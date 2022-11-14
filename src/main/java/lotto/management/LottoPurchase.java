package lotto.management;

public class LottoPurchase {

    static final int LOTTO_PRICE = 1000;

    final int LOTTO_TICKETS;

    public LottoPurchase(int purchaseMoney) {
        valid(purchaseMoney);
        this.LOTTO_TICKETS = changeMoneyToLottoTickets(purchaseMoney);
    }

    private int changeMoneyToLottoTickets(int purchaseAmount) {
        return purchaseAmount / LOTTO_PRICE;
    }

    private void valid(int purchaseMoney) {
        if (purchaseMoney % LOTTO_PRICE > 0) {
            throw new IllegalArgumentException("[ERROR] 구매 금액이 1000원 단위여야 합니다.");
        }
    }

    public int getNumberOfLottoTickets() {
        return LOTTO_TICKETS;
    }
}
