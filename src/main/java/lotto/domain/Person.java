package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Person {

    private List<Lotto> lottos;
    private HashMap<LottoPrize, Integer> lottoResults;

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

    private LottoPrize checkLottoResult(Lotto lotto) {
        return LottoPrize.getLottoPrize(
                countCorrectLottoNumber(lotto),
                countCorrectBonusNumber(lotto)
        );
    }

    private void resetLottoResult() {
        lottoResults = new HashMap<>();

        for (LottoPrize prize : LottoPrize.values()) {
            lottoResults.put(prize, 0);
        }
    }

    public void setLottoResult() {
        resetLottoResult();

        for (Lotto lotto : lottos) {
            LottoPrize result = checkLottoResult(lotto);
            if (lottoResults.containsKey(result)) lottoResults.put(result, lottoResults.get(result)+1);
            else lottoResults.put(result, 1);
        }
    }

    private int sumPrize() {
        int totalPrize = 0;

        for (LottoPrize result : lottoResults.keySet()) {
            totalPrize += result.getPrize()*lottoResults.get(result);
        }
        return totalPrize;
    }

    public float getReturnRate() {
        return (sumPrize()/(float)(lottos.size()*LottoConstant.PRICE.getValue()))*100;
    }

    public HashMap<LottoPrize, Integer> getLottoResult() {
        return lottoResults;
    }
}
