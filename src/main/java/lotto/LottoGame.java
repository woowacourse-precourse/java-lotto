package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGame {
    private Lottos lottoList = new Lottos(new ArrayList<>());
    public void buy(Money money) {
        int countOfBuy = money.lottoAccount(new Money(1000));
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < countOfBuy; i++) {
            lottos.add(Lotto.generateLottoNumbers());
        }

        this.lottoList = new Lottos(lottos);
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottoList.getLottos());
    }

    public LottoResult checkWinning(WinningNumbers winningNumbers) {
        return new LottoResult(lottoList.checkWinning(winningNumbers));
    }
}
