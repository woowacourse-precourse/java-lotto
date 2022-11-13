package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RaffleCounter {

    public RaffleCounter() {
    }

    public List<Integer> getResultOfLottos(List<Lotto> lottos, List<Integer> normalNumbers, Integer bonusNumbers) {
        List<Integer> resultOfLottos = new ArrayList<>(Arrays.asList(0,0,0,0,0,0));

        for (Lotto lotto : lottos) {
            Integer rank = countWinner(lotto, normalNumbers, bonusNumbers);
            int rankCount = resultOfLottos.get(rank)+1;
            resultOfLottos.set(rank, rankCount);
        }
        return resultOfLottos;
    }

    public Integer countWinner(Lotto lotto, List<Integer> normalNumbers, Integer bonusNumber) {
        int normalNumberCount = 0;
        int bonusNumberCount = 0;

        normalNumberCount = countNormalNumbers(lotto, normalNumbers);
        bonusNumberCount = countBonusNumber(lotto, bonusNumber);

        List<Integer> winnerResult = new ArrayList<>();
        winnerResult.add(normalNumberCount);
        winnerResult.add(bonusNumberCount);

        Integer rank = decideRank(winnerResult);

        return rank;
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

    private boolean isTargetNumberInNumbers(Integer targetNumber, List<Integer> numbers) {
        if (numbers.contains(targetNumber)) {
            return true;
        }
        return false;
    }


    private int countBonusNumber(Lotto lotto, Integer bonusNumber) {
        List<Integer> numbers = lotto.getNumbers();
        if (isTargetNumberInNumbers(bonusNumber, numbers)) {
            return 1;
        }
        return 0;
    }

    private Integer decideRank(List<Integer> winnerResult) {
        if (winnerResult.get(0) == 6) {
            return 1;
        }
        if (winnerResult.get(0) == 5 && winnerResult.get(1) == 1) {
            return 2;
        }
        if (winnerResult.get(0) == 5) {
            return 3;
        }
        if (winnerResult.get(0) == 4) {
            return 4;
        }
        if (winnerResult.get(0) == 3) {
            return 5;
        }
        return 0;
    }
}
