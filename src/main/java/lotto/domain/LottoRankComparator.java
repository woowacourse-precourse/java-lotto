package lotto.domain;

import java.util.Comparator;

public class LottoRankComparator implements Comparator<LottoRank> {
    @Override
    public int compare(LottoRank o1, LottoRank o2) {
        return o1.getReward() - o2.getReward();
    }
}
