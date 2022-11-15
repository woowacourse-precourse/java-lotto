package lotto.service;

import lotto.domain.*;

import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import static lotto.enumtype.LottoInterfaceMsg.WINNING_STATS_STRING;

public class LottoStatisticsService {
    private final LottoMachine lottoMachine;
    private final LottoWinningNumber lottoWinningNumber;

    public LottoStatisticsService(LottoMachine lottoMachine, LottoWinningNumber lottoWinningNumber) {
        this.lottoMachine = lottoMachine;
        this.lottoWinningNumber = lottoWinningNumber;
    }

    public void getResult(Money money) {
        System.out.println(WINNING_STATS_STRING.getMessage());
        SortedMap<LottoRank, Integer> countOfRank = setLottoRankIntegerSortedMap(lottoWinningNumber.getNumbers(), lottoWinningNumber.getBonusNumber());
        printStatistics(countOfRank);
        printTotalYield(countOfRank, money);
    }

    private void printStatistics(SortedMap<LottoRank, Integer> countOfRank) {
        StringBuilder sb = new StringBuilder();
        countOfRank.forEach((key, value) -> sb.append(key).append(" - ").append(value).append("개").append('\n'));
        System.out.print(sb);
    }

    private void printTotalYield(SortedMap<LottoRank, Integer> countOfRank, Money money) {
        long total = 0L;
        for (Map.Entry<LottoRank, Integer> entry : countOfRank.entrySet()) {
            total += (long) entry.getKey().getAmount() * entry.getValue();
        }

        System.out.println("총 수익률은 " + money.getYield(total) + "%입니다.");
    }

    private SortedMap<LottoRank, Integer> setLottoRankIntegerSortedMap(List<Integer> winningNumbers, int bonusNumber) {
        SortedMap<LottoRank, Integer> countOfRank = setCountOfRankMap();

        for (Lotto lotto : lottoMachine.getLottos()) {
            int count = getCorrectCount(winningNumbers, lotto.getNumbers());
            boolean isSameBonus = isSameBonusNumber(bonusNumber, lotto.getNumbers());

            LottoRank rank = LottoRank.calculate(count, isSameBonus);
            if (countOfRank.containsKey(rank)) {
                countOfRank.put(rank, countOfRank.get(rank) + 1);
            }
        }
        return countOfRank;
    }

    private SortedMap<LottoRank, Integer> setCountOfRankMap() {
        SortedMap<LottoRank, Integer> countOfRank = new TreeMap<>();
        List<LottoRank> ranks = LottoRank.getLottoRank();
        for (LottoRank rank : ranks) {
            countOfRank.put(rank, 0);
        }

        return countOfRank;
    }

    private int getCorrectCount(List<Integer> winningNumbers, List<Integer> lottoNumbers) {
        int count = 0;
        for (Integer number : lottoNumbers) {
            if (winningNumbers.contains(number)) {
                count++;
            }
        }

        return count;
    }

    private boolean isSameBonusNumber(int bonusNumber, List<Integer> lottoNumbers) {
        return lottoNumbers.contains(bonusNumber);
    }
}
