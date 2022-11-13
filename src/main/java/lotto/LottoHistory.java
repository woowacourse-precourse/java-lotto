package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoHistory {
    private final List<LottoRanking> winningHistory = new ArrayList<>();
    private LottoRanking lottoRanking;

    public LottoHistory() {
    }

    public List<LottoRanking> getHistorys() {
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

    public String getYield(long total, String amount) {
        return String.format("%.1f", (total * 100 / Double.parseDouble(amount)));
    }
}
