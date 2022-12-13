package lotto.model;

import java.util.List;

public class Customer {
    private final LottoTickets lottoTickets;
    private final PurchaseAmount purchaseAmount;

    public Customer(int purchaseAmount) {
        this.purchaseAmount = new PurchaseAmount(purchaseAmount);
        List<Lotto> purchasedLottoTickets = LottoMachine.buy(this.purchaseAmount);
        this.lottoTickets = new LottoTickets(purchasedLottoTickets);
    }
}
