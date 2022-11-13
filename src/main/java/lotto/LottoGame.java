package lotto;

import java.util.List;

public class LottoGame {
    private final LottoGenerator lottoGenerator;
    private final List<Lotto> lottos;
    private Lotto winningLotto;
    private LottoNumber bonusLottoNumber;

    LottoGame(PurchaseAmount purchaseAmount) {
        this.lottoGenerator = new LottoGenerator();
        this.lottos = this.lottoGenerator.generateLottos(purchaseAmount.getLottoCount());
    }

    public void play(Lotto winningLotto, LottoNumber bonusLottoNumber) {
        this.winningLotto = winningLotto;
        this.bonusLottoNumber = bonusLottoNumber;
    }

    private Integer compareLotto(Lotto lotto) {

    }
}
