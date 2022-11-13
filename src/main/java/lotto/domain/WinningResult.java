package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningResult {
    private final Lotto winningNumbers;
    private final LottoNumber bonusNumber;

    public WinningResult(Lotto winningNumbers, LottoNumber bonusNumber) {
        validateHasBonusNumber(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Rank check(Lotto issuedLotto) {
        int sameNumbersCount = issuedLotto.countSameNumbers(winningNumbers);
        boolean hasBonusNumber = issuedLotto.hasNumber(bonusNumber);
        return Rank.findRank(sameNumbersCount, hasBonusNumber);
    }

    public WinningStatistics compileStatistics(List<Lotto> lottos) {
        Map<Rank, Integer> statistics = new HashMap<>();
        for (Lotto lotto : lottos) {
            sumUpStatisticsForRank(statistics, check(lotto));
        }
        return new WinningStatistics(statistics);
    }

    private static void sumUpStatisticsForRank(Map<Rank, Integer> statistics, Rank rank) {
        statistics.put(rank, statistics.getOrDefault(rank, 0) + 1);
    }

    private void validateHasBonusNumber(Lotto winningNumbers, LottoNumber bonusNumber) {
        if (winningNumbers.hasNumber(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 당첨 번호에 포함되어 있습니다.");
        }
    }
}
