package lotto.domain.lottoData;

import java.util.List;

public class TotalWinnerLotto {
    private final List<Integer> rankList;

    public TotalWinnerLotto(List<Integer> rankList) {
        this.rankList = rankList;
    }

    public Integer getResultWithRank(Integer rank) {
        return rankList.get(rank);
    }
}
