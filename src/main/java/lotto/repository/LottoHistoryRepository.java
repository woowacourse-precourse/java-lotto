package lotto.repository;

import java.util.List;
import lotto.domain.LottoHistory;
import lotto.domain.LottoRanking;

public class LottoHistoryRepository extends LottoHistory {
    public LottoHistoryRepository() {
    }

    @Override
    public List<LottoRanking> getWinningHistory() {
        return super.getWinningHistory();
    }

    @Override
    public void saveHistory(String ranking) {
        super.saveHistory(ranking);
    }

    @Override
    public long getTotal(List<LottoRanking> winningHistory) {
        return super.getTotal(winningHistory);
    }

    @Override
    public String getYield(long total, String amount) {
        return super.getYield(total, amount);
    }

    @Override
    public int getWinningCount(List<LottoRanking> winningHistory, LottoRanking ranking) {
        return super.getWinningCount(winningHistory, ranking);
    }
}