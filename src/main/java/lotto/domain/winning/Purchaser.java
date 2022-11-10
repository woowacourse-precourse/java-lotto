package lotto.domain.winning;

import java.util.List;
import lotto.domain.lotto_numbers.Lotto;

public class Purchaser {

    private final List<Lotto> purchasedLottos;

    public Purchaser(List<Lotto> purchasedLottos) {
        this.purchasedLottos = purchasedLottos;
    }

    public LottoResults lottoResults(WinningNumbers winningNumbers) {
        return winningNumbers.lottoResults(purchasedLottos);
    }

    // 테스트용 메서드
    public int lottoListSize() {
        return purchasedLottos.size();
    }
}