package lotto;

import java.util.List;

public class ResultLotto {
    private final List<Integer> rankList;

    public ResultLotto(List<Integer> rankList) {
        this.rankList = rankList;
    }

    public Integer getResultWithRank(Integer rank) {
        return rankList.get(rank);
    }
}
