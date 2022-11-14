package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.enums.LottoRanking;

public class LottoHistory {
    private final List<LottoRanking> winningHistory = new ArrayList<>();

    public LottoHistory() {
    }

    public List<LottoRanking> getWinningHistory() {
        return winningHistory;
    }

    public void saveHistory(String ranking) {
        if (LottoRanking.FIRST.name().equals(ranking)) {
            this.winningHistory.add(LottoRanking.valueOf(ranking));
        }
        if (LottoRanking.SECOND.name().equals(ranking)) {
            this.winningHistory.add(LottoRanking.valueOf(ranking));
        }
        if (LottoRanking.THIRD.name().equals(ranking)) {
            this.winningHistory.add(LottoRanking.valueOf(ranking));
        }
        if (LottoRanking.FOURTH.name().equals(ranking)) {
            this.winningHistory.add(LottoRanking.valueOf(ranking));
        }
        if (LottoRanking.FIFTH.name().equals(ranking)) {
            this.winningHistory.add(LottoRanking.valueOf(ranking));
        }
    }

    public long getTotal(List<LottoRanking> winningHistory) {
        long total = 0L;
        for (LottoRanking ranking : winningHistory) {
            total += ranking.getMoney();
        }
        return total;
    }

    public String getYield(long total, String amount) {
        return String.format("%.1f", (total * 100 / Double.parseDouble(amount)));
    }

    public int getWinningCount(List<LottoRanking> winningHistory, LottoRanking ranking) {
        return Collections.frequency(winningHistory, ranking);
    }
}