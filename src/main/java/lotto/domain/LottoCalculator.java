package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoCalculator {

    private Map<Rank, Integer> lottoResult = new HashMap<>();

    public void initLottoResult() {
        for (Rank rank : Rank.values()) {
            lottoResult.put(rank, 0);
        }
    }

    public int countMatchedNumber(Lotto lotto, Lotto winningLotto) {
        List<Integer> winningNumbers = winningLotto.getLottoNumbers();
        return (int) lotto.getLottoNumbers().stream()
                .filter(winningNumbers::contains)
                .count();
    }
}
