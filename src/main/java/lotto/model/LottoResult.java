package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private final Map<Prize, Integer> statistics;
    private final double prizeMoney;

    public Map<Prize, Integer> getStatistics() {
        return statistics;
    }

    public double getPrizeMoney() {
        return prizeMoney;
    }

    public LottoResult(Ticket ticket, WinningLotto winningLotto) {
        this.statistics = getStatistics(ticket, winningLotto);
        this.prizeMoney = getPrizeMoney(statistics);
    }

    private Map<Prize, Integer> getStatistics(Ticket ticket, WinningLotto winningNumbers) {
        List<Lotto> lotteries = ticket.getLotteries();
        Map<Prize, Integer> statistics = new HashMap<>();
        init(statistics);

        for (Lotto lotto : lotteries) {
            List<Integer> lottoNumbers = lotto.getNumbers();
            Prize prize = getPrize(lottoNumbers, winningNumbers);
            statistics.put(prize, statistics.get(prize) + 1);
        }

        return statistics;
    }

    private Prize getPrize(List<Integer> lottoNumbers, WinningLotto winningLotto) {
        int matchCount = matchNumber(lottoNumbers, winningLotto);
        boolean containBonusNumber = isContainBonusNumber(lottoNumbers, winningLotto);

        if (matchCount == 6) return Prize.FIRST;
        if (matchCount == 5 && containBonusNumber) return Prize.SECOND;
        if (matchCount == 5) return Prize.THIRD;
        if (matchCount == 4) return Prize.FOURTH;
        if (matchCount == 3) return Prize.FIFTH;

        return Prize.NONE;
    }

    private int matchNumber(List<Integer> lottoNumbers, WinningLotto winningLotto) {
        List<Integer> winningNumbers = winningLotto.getWinningNumbers();
        int matchCount = 0;

        for (Integer lottoNumber : lottoNumbers) {
            if (winningNumbers.contains(lottoNumber)) {
                matchCount++;
            }
        }

        return matchCount;
    }

    private boolean isContainBonusNumber(List<Integer> lottoNumbers, WinningLotto winningLotto) {
        return lottoNumbers.contains(winningLotto.getBonusNumber());
    }

    private double getPrizeMoney(Map<Prize, Integer> statistics) {
        double prizeMoney = 0;
        prizeMoney += 2000000000L * statistics.get(Prize.FIRST);
        prizeMoney += 30000000L * statistics.get(Prize.SECOND);
        prizeMoney += 1500000L * statistics.get(Prize.THIRD);
        prizeMoney += 50000L * statistics.get(Prize.FOURTH);
        prizeMoney += 5000L * statistics.get(Prize.FIFTH);
        return prizeMoney;
    }

    private void init(Map<Prize, Integer> statistics) {
        for (Prize prize : Prize.values()) {
            statistics.put(prize, 0);
        }
    }
}
