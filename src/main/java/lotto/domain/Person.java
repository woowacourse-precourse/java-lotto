package lotto.domain;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Person {
    private List<Lotto> lottos;
    private List<LottoPrize> lottoResults;

    public void buyLottos(LottoMachine lottoMachine) {
        this.lottos = lottoMachine.sellLottos();
    }

    private int countCorrectLottoNumber(Lotto lotto) {
        List<Integer> winningLottoNumber = WinningLotto.getWinningLottoNumber();
        Set<Integer> count = lotto.getLottoNumbers()
                .stream()
                .filter(winningLottoNumber::contains)
                .collect(Collectors.toSet());
        return count.size();
    }

    private int countCorrectBonusNumber(Lotto lotto) {
        if (lotto.getLottoNumbers()
                .contains(WinningLotto.getWinningBonusNumber()))
            return 1;
        return 0;
    }

    private LottoPrize getLottoResult(Lotto lotto) {
        return LottoPrize.getLottoPrize(
                countCorrectLottoNumber(lotto),
                countCorrectBonusNumber(lotto)
        );
    }

    private void setLottoResult() {
        for (Lotto lotto : lottos) {
            lottoResults.add(getLottoResult(lotto));
        }
    }

    private int sumPrize() {
        int totalPrize = 0;
        for (LottoPrize result : lottoResults) {
            totalPrize += result.getPrize();
        }
        return totalPrize;
    }

    private float getReturnRate() {
        return Math.round((sumPrize()/lottoResults.size())*10/10.0);
    }

    public List<LottoPrize> getLottoResult() {
        return lottoResults;
    }
}
