package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoResult {
    private final List<Integer> rankCounts; // 각 등수별 개수
    int rankTypeNumbers = Rank.values().length;  // 랭크의 종류 개수

    public LottoResult() {
        this.rankCounts = new ArrayList<>(Collections.nCopies(rankTypeNumbers + 1, 0));
        // 모든 항을 0으로 초기화
    }

    public void putRanking(int ranking) {
        rankCounts.set(ranking, rankCounts.get(ranking) + 1);
    }

    public int getRankCounts(int index) {
        return rankCounts.get(index);
    }
}
