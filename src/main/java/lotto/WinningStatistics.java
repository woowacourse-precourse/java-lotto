package lotto;

import lotto.enums.EtcNumber;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningStatistics {
    private final int rankSize = EtcNumber.RANK_SIZE.getNumber();

    private int bonusBall;
    private int totalProfit;
    private List<Lotto> lottoTickets;
    private List<Integer> winningLotto;
    private HashMap<Integer, Integer> countRank = new HashMap<>();

    WinningStatistics(LottoTickets lottoTickets, WinningLotto winningLotto, BonusBall bonusBall) {
        this.lottoTickets = lottoTickets.getLottoTickets();
        this.winningLotto = winningLotto.getWinningNumbers();
        this.bonusBall = bonusBall.getBonusNumber();
        initCountRank();
        countRankPrize();
    }

    public void initCountRank() {
        for(int rank = EtcNumber.FIRST_RANK.getNumber(); rank <= rankSize; rank++) {
            countRank.put(rank, EtcNumber.ZERO.getNumber());
        }
    }

    public void sumProfit(LottoWinningChecker lottoWinningChecker) {
        totalProfit += lottoWinningChecker.getProfit();
    }

    public void countRankPrize() {
        for (Lotto lotto : lottoTickets) {
            LottoWinningChecker lottoWinningChecker = new LottoWinningChecker(lotto, winningLotto, bonusBall);
            sumProfit(lottoWinningChecker);
            plusRankCount(lottoWinningChecker);
        }
    }

    public void plusRankCount(LottoWinningChecker lottoWinningChecker) {
        int rank = lottoWinningChecker.getRank();
        if(rank != EtcNumber.ZERO.getNumber()) {
            int count = countRank.get(rank);
            countRank.put(rank, ++count);
        }

    }

    public Map<Integer, Integer> getWinningCountStatistics() {
        return countRank;
    }

    public int getTotalProfit() {
        return totalProfit;
    }
}
