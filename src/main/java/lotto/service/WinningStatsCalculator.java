package lotto.service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import lotto.domain.Lotto;
import lotto.utils.constants.IntegerCommon;
import lotto.utils.constants.Winning;

public class WinningStatsCalculator {

    Map<Integer, Long> winningStats;
    double returnRate;

    public WinningStatsCalculator(List<Lotto> lottoNumbers, Lotto winningNumbers,
                                  int bonusNumber, long purchaseAmount) {
        this.winningStats = getWinningStats(lottoNumbers, winningNumbers, bonusNumber);
    }

    private Map<Integer, Long> getWinningStats(List<Lotto> lottoNumbers, Lotto winningNumbers, int bonusNumber) {
        Map<Integer, Long> winningStats = new TreeMap<>();
        for (Lotto lottoNumber : lottoNumbers) {
            int winningCount = getWinningCount(lottoNumber, winningNumbers);
            boolean bonusCoincide = isCoincideBonusNumber(lottoNumber, bonusNumber, winningCount);
            int winningRank = getWinningRank(winningCount, bonusCoincide);
            winningStats.merge(winningRank, 1L, Long::sum);
        }
        return winningStats;
    }

    private boolean isCoincideBonusNumber(Lotto lottoNumber, int bonusNumber, int winningCount) {
        if (winningCount != Winning.SECOND_PLACE.getMatchAmount()) {
            return false;
        }
        return lottoNumber.getNumbers().contains(bonusNumber);
    }

    private int getWinningCount(Lotto lottoNumber, Lotto winningNumber) {
        int winningCount = IntegerCommon.ZERO.getNumber();
        for (int index = IntegerCommon.ZERO.getNumber(); index < lottoNumber.getNumbers().size(); index++) {
            winningCount = checkCoincide(lottoNumber, winningNumber, winningCount, index);
        }
        return winningCount;
    }

    /**
     * 당첨 번호에 생성된 로또 번호가 포함되는지 확인하는 메서드
     */
    private int checkCoincide(Lotto lottoNumber, Lotto winningNumber, int winningCount, int index) {
        if (isCoincide(lottoNumber.getNumbers().get(index), winningNumber)) {
            winningCount++;
        }
        return winningCount;
    }

    private boolean isCoincide(int number, Lotto winningNumber) {
        return winningNumber.getNumbers().contains(number);
    }

    /**
     * 일치하는 번호의 개수와 보너스 일치 여부를 통해,
     * 당첨 등수를 구하는 메서드
     */
    private int getWinningRank(int winningCount, boolean bonusCoincide) {
        Optional<Winning> rank =
                Arrays.stream(Winning.values())
                .filter((winning) -> winning.getMatchAmount() == winningCount
                        && winning.isMatchBonus() == bonusCoincide).findAny();
        if (rank.isEmpty()) {
            return IntegerCommon.ZERO.getNumber();
        }
        return rank.get().getRank();
    }

    public double getReturnRate() {
        return returnRate;
    }

    public Map<Integer, Long> getWinningStats() {
        return winningStats;
    }
}
