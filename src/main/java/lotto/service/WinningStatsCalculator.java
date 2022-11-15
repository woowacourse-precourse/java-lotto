package lotto.service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import lotto.domain.Lotto;
import lotto.utils.constants.DoubleCommon;
import lotto.utils.constants.IntegerCommon;
import lotto.utils.constants.LottoConstant;
import lotto.utils.constants.Winning;

public class WinningStatsCalculator {

    Map<Integer, Long> winningStats;
    double returnRate;

    public WinningStatsCalculator(List<Lotto> lottoNumbers, Lotto winningNumbers,
                                  int bonusNumber, long purchaseAmount) {
        this.winningStats = getWinningStats(lottoNumbers, winningNumbers, bonusNumber);
        this.returnRate = getReturnRate(purchaseAmount, getWinningMoney(winningStats));
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

    /**
     * 당첨 금액을 구하는 메서드
     * 당첨금 += 해당 등수의 당첨금 * 해당 등수 당첨 개수
     */
    private long getWinningMoney(Map<Integer, Long> winningStats) {
        long winningMoney = IntegerCommon.ZERO.getNumber();
        for (int index = IntegerCommon.ZERO.getNumber(); index < Winning.values().length; index++) {
            winningMoney +=
                    (long) Winning.values()[index].getMoney()
                    * winningStats.getOrDefault(index + IntegerCommon.COUNT.getNumber(),
                    (long) IntegerCommon.ZERO.getNumber());
        }
        return winningMoney;
    }

    /**
     * 구입 금액, 당첨 금액을 이용해 수익률을 구하는 메서드
     * ((당첨 금액 / 구입 금액) * 100 * 10) / 10
     * 10을 곱하고 나누는 것은, round 메서드를 통해 소수점 2번째 자리에서 반올림 해야하기 때문
     */
    private double getReturnRate(long purchaseAmount, long winningMoney) {
        long purchaseMoney = purchaseAmount * LottoConstant.LOTTO_AMOUNT_UNIT.getNumber();
        if (purchaseMoney == IntegerCommon.ZERO.getNumber()) {
            return DoubleCommon.ZERO_DOUBLE.getFixer();
        }
        return (double) Math.round(
                ((double) winningMoney / purchaseMoney) * IntegerCommon.MAX_PERCENTAGE.getNumber()
                        * IntegerCommon.ROUND_MULTIPLICATION.getNumber()) / DoubleCommon.ROUND_DIVISOR.getFixer();
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
