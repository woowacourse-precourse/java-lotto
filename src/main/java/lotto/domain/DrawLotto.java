package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class DrawLotto {
    List<Lotto> lottoList;
    List<Integer> winner;
    Ranking rank;
    int bonus;
    public DrawLotto(List<Lotto> lottoList, List<Integer> winner, int bonus) {
        this.lottoList = lottoList;
        this.winner = winner;
        this.bonus = bonus;
    }
    public int checkLotto(Lotto lotto) {
        int matchCounts = 0;
        for (int value : winner) {
            if (lotto.contains(value)) {
                matchCounts++;
            }
        }
        return matchCounts;
    }
    public boolean checkBonus(Lotto lotto) {
        if (lotto.contains(bonus)) {
            return true;
        }
        return false;
    }

    private Map<Ranking, Integer> setupComparison() {
        Map<Ranking, Integer> comparison = new HashMap<Ranking, Integer>();
        for (Ranking rank : Ranking.values()) {
            comparison.put(rank, 0);
        }
        return comparison;
    }
}
