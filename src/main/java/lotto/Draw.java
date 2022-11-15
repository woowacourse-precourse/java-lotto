package lotto;

import java.util.List;
import java.util.function.Predicate;

public class Draw {

    public Double getMatchingCount(List<Integer> lotto, List<Integer> winningNumber, Integer bonusNumber) {
        double matchingNumber = (double) lotto.stream()
                .filter(ln -> winningNumber.stream()
                        .anyMatch(Predicate.isEqual(ln)))
                .count();

        if (lotto.contains(bonusNumber)) {
            matchingNumber += 0.5;
        }


        return matchingNumber;
    }

    public void saveWinningCount(Double matchingNumber) {
        if (matchingNumber == 3.0) {
            WinnersCase.FIFTH.addCount();
            return;
        }
        if (matchingNumber == 4.0) {
            WinnersCase.FOURTH.addCount();
            return;
        }
        if (matchingNumber == 5.0) {
            WinnersCase.THIRD.addCount();
            return;
        }
        if (matchingNumber == 5.5) {
            WinnersCase.SECOND.addCount();
            return;
        }
        if (matchingNumber == 6.0) {
            WinnersCase.FIRST.addCount();
            return;
        }
    }

    public void saveWinningCase(List<List<Integer>> lotteries, List<Integer> winningNumber, Integer bonusNumber) {
        Double matchingNumber = 0.0;
        for (List<Integer> lottery : lotteries) {
            matchingNumber = getMatchingCount(lottery, winningNumber, bonusNumber);
            saveWinningCount(matchingNumber);
        }
    }

    public void savePrizeMoney() {
        WinnersCase.FIFTH.totalPrizeMoney(WinnersCase.FIFTH.getPrizeMoney(), WinnersCase.FIFTH.getCount());
        WinnersCase.FOURTH.totalPrizeMoney(WinnersCase.FOURTH.getPrizeMoney(), WinnersCase.FOURTH.getCount());
        WinnersCase.THIRD.totalPrizeMoney(WinnersCase.THIRD.getPrizeMoney(), WinnersCase.THIRD.getCount());
        WinnersCase.SECOND.totalPrizeMoney(WinnersCase.SECOND.getPrizeMoney(), WinnersCase.SECOND.getCount());
        WinnersCase.FIRST.totalPrizeMoney(WinnersCase.FIRST.getPrizeMoney(), WinnersCase.FIRST.getCount());
    }

}