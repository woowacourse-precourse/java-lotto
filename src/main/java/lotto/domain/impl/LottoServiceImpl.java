package lotto.domain.impl;

import lotto.Lotto;
import lotto.Rank;
import lotto.domain.Judgment;
import lotto.domain.LottoService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static lotto.Rank.*;

public class LottoServiceImpl implements LottoService {

    private final Judgment judgment = new JudgmentImpl();
    private final Map<Integer, Rank> ranks = new HashMap<>() {
        {
            put(3, FIFTH);
            put(4, FOURTH);
            put(5, THIRD);
            put(6, FIRST);
        }
    };

    @Override
    public Map<Rank, Integer> compare(List<Lotto> userLottos, Lotto prizeLotto, int bonusNumber) {
        Map<Rank, Integer> results = new HashMap<>();

        for (Lotto userLotto : userLottos) {
            List<Integer> userNumbers = userLotto.getNumbers();
            List<Integer> prizeNumbers = prizeLotto.getNumbers();
            int count = judgment.correctCount(userNumbers, prizeNumbers);
            boolean hasBonusNumber = false;
            if (count == 5) {
                hasBonusNumber = judgment.hasBonusNumber(userNumbers, bonusNumber);
            }
            Rank rank = getRank(count, hasBonusNumber);
            int resultCount = results.getOrDefault(rank, 0);
            results.put(rank, resultCount + 1);
        }

        return results;
    }

    private Rank getRank(int count, boolean hasBonusNumber) {
        if (count == 5 && hasBonusNumber) {
            return SECOND;
        }
        return ranks.get(count);
    }

    @Override
    public double calculateRate(Map<Rank, Integer> results, int amount) {
        double totalPrize = 0;
        for (Rank rank : results.keySet()) {
            int count = results.get(rank);
            totalPrize += rank.getPrize() * count;
        }
        return totalPrize / amount;
    }
}
