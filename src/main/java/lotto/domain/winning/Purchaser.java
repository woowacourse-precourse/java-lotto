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
        double totalPrices = PRICE_OF_LOTTO * purchasedLottos.size();

        return totalWinnings / totalPrices * 100;
    }

    // 테스트용 메서드
    public int lottoListSize() {
        return purchasedLottos.size();
    }
}