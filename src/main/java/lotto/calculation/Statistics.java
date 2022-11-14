package lotto.calculation;

import lotto.exception.IllegalArgument;
import lotto.generation.Lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Statistics {

    public HashMap<Lotto, List<Integer>> getTotalWinningCount(List<Lotto> lottos, Winning winning) {
        HashMap<Lotto, List<Integer>> totalWinningCount = new HashMap<>();
        for (Lotto lotto : lottos) {
            totalWinningCount.put(lotto, getWinningCount(lotto.getNumbers(), winning));
        }
        return totalWinningCount;
    }

    public List<Integer> getWinningCount(List<Integer> numbers, Winning winning) {
        List<Integer> winningCount = new ArrayList<>();
        int count = 0;
        for (int winningNumber : winning.getWinningNumbers()) {
            if (numbers.contains(winningNumber)) {
                count++;
            }
        }
        winningCount.add(count);
        if (count == 5 && matchBonusNumber(numbers, winning)) {
            winningCount.add(1);
            return winningCount;
        }
        winningCount.add(0);
        return winningCount;
    }

    public boolean matchBonusNumber(List<Integer> numbers, Winning winning) {
        int bonusNumber = 0;
        do {
            bonusNumber = Randoms.pickNumberInRange(1, 45);
        } while (!IllegalArgument.isRedundancyWithNumbers(bonusNumber, numbers));
        if (bonusNumber == winning.getBonusNumber()) {
            return true;
        }
        return false;
    }
}
