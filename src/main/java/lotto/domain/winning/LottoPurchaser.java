package lotto.domain.winning;

import java.util.List;
import lotto.domain.lotto_numbers.Lotto;

public class LottoPurchaser {

    public static final int PRICE_OF_LOTTO = 1_000;

    private final List<Lotto> purchasedLottos;

    public LottoPurchaser(List<Lotto> purchasedLottos) {
        this.purchasedLottos = purchasedLottos;
    }

    public LottoResults lottoResults(WinningNumbers winningNumbers) {
        return winningNumbers.lottoResults(purchasedLottos);
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
            stringBuilder.append(purchasedLotto.numbers()).append("\n");
        }
        // 오름차순으로 정렬된 값을 보여줘야 함.
        return stringBuilder.toString();
    }
}