package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoReader {
    public void createLottoResult(List<Lotto> publishedLotto, Lotto winningLotto, Bonus bonus) {
        Map<Lotto, Integer> matchingResult = createMatchingResult(publishedLotto, winningLotto);
    }

    private Map<Lotto, Integer> createMatchingResult(List<Lotto> publishedLotto, Lotto winningLotto) {
        Map<Lotto, Integer> matchingResult = new HashMap<>();

        for (Lotto lotto : publishedLotto) {
            matchingResult.put(lotto, lotto.countMatchingNumbers(winningLotto));
        }

        return matchingResult;
    }
}
