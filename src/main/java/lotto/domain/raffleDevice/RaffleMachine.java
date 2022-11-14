package lotto.domain.raffleDevice;

import lotto.domain.Rank;
import lotto.domain.lottoData.Lotto;

import java.util.*;

public class RaffleMachine {

    public Map<Rank, Integer> getWinnerPerRank(List<Lotto> lottos, List<Integer> normalNumbers, Integer bonusNumbers) {
        // TODO : Integer 0으로 초기화하여 구현
        Map<Rank, Integer> winnerPerRank = new HashMap<>();

        for (Lotto lotto : lottos) {
            Rank rank = decideRank(lotto, normalNumbers, bonusNumbers);
            Integer winnerCount = winnerPerRank.get(rank) + 1;
            winnerPerRank.put(rank, winnerCount);
        }
        return winnerPerRank;
    }

    private Rank decideRank(Lotto lotto, List<Integer> normalNumbers, Integer bonusNumber) {
        int normalNumberCount = countNormalNumbers(lotto, normalNumbers);
        int bonusNumberCount = countBonusNumber(lotto, bonusNumber);

        return getRank(normalNumberCount, bonusNumberCount);
    }

    private int countNormalNumbers(Lotto lotto, List<Integer> normalNumbers) {
        int winningNumberCount = 0;
        List<Integer> numbers = lotto.getNumbers();
        for (Integer normalNumber : normalNumbers) {
            if (isTargetNumberInNumbers(normalNumber, numbers)) {
                winningNumberCount += 1;
            }
        }
        return winningNumberCount;
    }

    private int countBonusNumber(Lotto lotto, Integer bonusNumber) {
        List<Integer> numbers = lotto.getNumbers();
        if (isTargetNumberInNumbers(bonusNumber, numbers)) {
            return 1;
        }
        return 0;
    }

    private Rank getRank(int normalNumberCount, int bonusNumberCount) {
        Rank[] ranks = Rank.values();
        for (Rank rank : ranks) {
            if (bonusNumberCount == 1 && rank.getNormalNumbers() == normalNumberCount) {
                return Rank.SECOND;
            }
            if (rank.getNormalNumbers() == normalNumberCount) {
                return rank;
            }
        }
        return Rank.NONE;
    }


    private boolean isTargetNumberInNumbers(Integer targetNumber, List<Integer> numbers) {
        if (numbers.contains(targetNumber)) {
            return true;
        }
        return false;
    }


}
