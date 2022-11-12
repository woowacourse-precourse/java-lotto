package lotto.domain.winning;

import static lotto.domain.policy.LottoPolicy.PRICE_OF_LOTTO;

import java.util.List;
import lotto.domain.lotto_numbers.Lotto;

public class PurchasedLottoTickets {

    private final List<Lotto> purchasedLottoTickets;

    public PurchasedLottoTickets(List<Lotto> purchasedLottoTickets) {
        this.purchasedLottoTickets = purchasedLottoTickets;
    }

    public LottoResults lottoResults(WinningLotto winningLotto) {
        return winningLotto.lottoResults(purchasedLottoTickets);
    }

    public int totalPayment() {
        return PRICE_OF_LOTTO * totalCounts();
    }

    public int totalCounts() {
        return purchasedLottoTickets.size();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Lotto purchasedLotto : purchasedLottoTickets) {
            stringBuilder
                    .append(purchasedLotto)
                    .append("\n");
        }

        return stringBuilder.toString();
    }
}