package lotto.domain.winning;

import static lotto.domain.policy.LottoPolicy.PRICE_OF_LOTTO;

import java.util.List;
import lotto.domain.lotto_numbers.Lotto;

public class LottoPurchaser {

    private final List<Lotto> purchasedLottos;

    public LottoPurchaser(List<Lotto> purchasedLottos) {
        this.purchasedLottos = purchasedLottos;
    }

    public LottoResults lottoResults(WinningLotto winningLotto) {
        return winningLotto.lottoResults(purchasedLottos);
    }

    public double rateOfReturn(LottoResults results) {
        int totalWinnings = results.totalWinnings();
        double totalPricesOfPurchase = PRICE_OF_LOTTO * purchasedLottos.size();
        double rateOfReturn = totalWinnings / totalPricesOfPurchase * 100;

        return (double) Math.round(rateOfReturn * 10) / 10;
    }

    public int numberOfPurchasedLottos() {
        return purchasedLottos.size();
    }

    public String purchasedLottosFormat() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Lotto purchasedLotto : purchasedLottos) {
            stringBuilder
                    .append(purchasedLotto.numbers())
                    .append("\n");
        }

        return stringBuilder.toString();
    }
}