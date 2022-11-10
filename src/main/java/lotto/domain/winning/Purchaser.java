package lotto.domain.winning;

import java.util.List;
import lotto.domain.lotto_numbers.Lotto;

public class Purchaser {

    public static final int PRICE_OF_LOTTO = 1_000;
    private final List<Lotto> purchasedLottos;

    public Purchaser(List<Lotto> purchasedLottos) {
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

    // 테스트용 메서드
    public int lottoListSize() {
        return purchasedLottos.size();
    }
}