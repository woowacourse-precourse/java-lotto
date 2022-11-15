package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private List<Lotto> lottos = new ArrayList<>();
    public void buy(Money money) {
        int countOfBuy = money.lottoAccount(new Money(1000));
        for (int i = 0; i < countOfBuy; i++) {
            Lotto lotto = Lotto.generateLottoNumbers();
            lottos.add(lotto);
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public LottoResult checkWinning(WinningNumbers winningNumbers) {
        Lottos lottos1 = new Lottos(lottos);
        return new LottoResult(lottos1.checkWinning(winningNumbers));
    }
}
