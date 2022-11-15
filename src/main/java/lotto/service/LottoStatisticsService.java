package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoRank;
import lotto.domain.LottoWinningNumber;

import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

public class LottoStatisticsService {
    private final LottoMachine lottoMachine;
    private final LottoWinningNumber lottoWinningNumber;

    public LottoStatisticsService(LottoMachine lottoMachine, LottoWinningNumber lottoWinningNumber) {
        this.lottoMachine = lottoMachine;
        this.lottoWinningNumber = lottoWinningNumber;
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
