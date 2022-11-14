package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class LottoGame {
    private final LottoGenerator lottoGenerator;
    private final PurchaseAmount purchaseAmount;
    private final List<Lotto> lottos;
    private List<Integer> winningCounts;

    LottoGame(PurchaseAmount purchaseAmount) {
        this.lottoGenerator = new LottoGenerator();
        this.purchaseAmount = purchaseAmount;
        this.lottos = this.lottoGenerator.generateLottos(purchaseAmount.getLottoCount());
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

    public void play(Lotto winningLotto, LottoNumber bonusLottoNumber) {
        winningLotto.checkBonusNumber(bonusLottoNumber);
        winningCounts = this.lottos.stream().map(lotto -> lotto.getMatchCount(winningLotto, bonusLottoNumber))
                .collect(Collectors.toList());
    }

    public Result getResult() {
        return new Result(winningCounts, purchaseAmount);
    }
}
