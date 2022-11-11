package lotto;

import java.util.List;

public class LottoBuyer {
    private List<Lotto> lottos;

    public void buy(String payment) {
        this.lottos = LottoGenerator.generate(payment);
    }

    public void showLottos() {
        for (Lotto lotto : this.lottos) {
            lotto.printLottoNumbers();
        }
    }
}
