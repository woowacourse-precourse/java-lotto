package lotto.domain;

import java.util.List;
import java.util.Map;

public class DrawLotto {
    ListOfLottos lottoList;
    List<Integer> winner;
    Ranking rank;
    int bonus;
    public DrawLotto(ListOfLottos lottoList, List<Integer> winner, int bonus) {
        this.lottoList = lottoList;
        this.winner = winner;
        this.bonus = bonus;
    }
    public int checkLotto(Lotto lotto) {
        int matchCounts = 0;
        for (int value : winner) {
            if (lotto.getLotto().contains(value)) {
                matchCounts++;
            }
        }
        return matchCounts;
    }

}
