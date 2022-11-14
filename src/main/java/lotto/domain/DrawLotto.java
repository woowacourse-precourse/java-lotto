package lotto.domain;

import java.util.Arrays;
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
        if (checkLotto(lotto)==5 && lotto.contains(bonus)) {
            return true;
        }
        return false;
    }
    public Ranking getRank(Lotto lotto) {
        int match = checkLotto(lotto);
        boolean bonusMatch = checkBonus(lotto);
        return  Arrays.stream(Ranking.values())
                .filter(l -> l.getMatch()==(match))
                .filter(l -> l.getBonusMatch()==(bonusMatch))
                .findFirst()
                .get();
    }
    private Map<Ranking, Integer> setupComparison() {
        Map<Ranking, Integer> comparison = new HashMap<Ranking, Integer>();
        for (Ranking rank : Ranking.values()) {
            comparison.put(rank, 0);
        }
        return comparison;
    }
}
