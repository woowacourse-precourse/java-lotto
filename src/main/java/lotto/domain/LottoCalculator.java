package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoCalculator {

    private long totalProfit = 0L;
    private Map<Rank, Integer> lottoResult = new HashMap<>();

    public Map<Rank, Integer> calculateResult(List<Lotto> lottos, Lotto winningLotto, int bonusNumber) {
        initLottoResult();
        for (Lotto lotto : lottos) {
            int matchCount = countMatchedNumber(lotto, winningLotto);
            Rank rank = Rank.valueOf(lotto, bonusNumber, matchCount);
            lottoResult.put(rank, lottoResult.get(rank) + 1);
            totalProfit += rank.getMatchMoney();
        }
        return lottoResult;
    }

    private void initLottoResult() {
        for (Rank rank : Rank.values()) {
            lottoResult.put(rank, 0);
        }
    }

    private int countMatchedNumber(Lotto lotto, Lotto winningLotto) {
        List<Integer> winningNumbers = winningLotto.getLottoNumbers();
        return (int) lotto.getLottoNumbers().stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public double calculateProfitRate(int amount) {
        return totalProfit / (double) amount * 100;
    }
}
