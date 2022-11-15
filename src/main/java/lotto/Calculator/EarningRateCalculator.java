package lotto.Calculator;

import lotto.Printer.Printer;

import java.util.List;

public class EarningRateCalculator {
    private static final Integer STANDARD_UNIT = 1000;

    private static final Integer FIFTH_PLACE_PRIZE = 5000;
    private static final Integer FOURTH_PLACE_PRIZE = 50000;
    private static final Integer THIRD_PLACE_PRIZE = 1500000;
    private static final Integer SECOND_PLACE_PRIZE = 30000000;
    private static final Integer FIRST_PLACE_PRIZE = 2000000000;

    private Integer fifthPlaceCount = 0;
    private Integer fourthPlaceCount = 0;
    private Integer thirdPlaceCount = 0;
    private Integer secondPlaceCount = 0;
    private Integer firstPlaceCount = 0;

    private Integer prize = 0;
    private float earningRate;

    public void checkMatching(List<Integer> userLotto, List<List<Integer>> lottos, Integer bonusNumber, Printer printer) {
        for (List<Integer> lotto : lottos) {
            winningCalculate(userLotto, lotto, bonusNumber);
        }

        calculatePrize();
        calculateEarningRate(lottos.size());
        System.out.println(prize);
        printer.printWinningStatistics(fifthPlaceCount, fourthPlaceCount , thirdPlaceCount, secondPlaceCount, firstPlaceCount,
                earningRate);
    }

    private void winningCalculate(List<Integer> userLotto, List<Integer> lotto, Integer bonusNumber) {
        for (Integer number : lotto) {
            if (userLotto.contains(number)) {
                userLotto.remove(number);
            }
        }
        matchCount(userLotto, bonusNumber);
    }

    private void matchCount(List<Integer> userLotto, Integer bonusNumber) {
        if (userLotto.size() == 3) {
            fifthPlaceCount++;
        }
        if (userLotto.size() == 2) {
            fourthPlaceCount++;
        }
        if (userLotto.size() == 1) {
            checkBonusNumber(userLotto, bonusNumber);
        }
        if (userLotto.size() == 0) {
            firstPlaceCount++;
        }
    }

    private void checkBonusNumber(List<Integer> userLotto, Integer bonusNumber) {
        if (userLotto.contains(bonusNumber)) {
            secondPlaceCount++;
            return;
        }
        thirdPlaceCount++;
    }

    private void calculatePrize() {
        prize = (fifthPlaceCount * FIFTH_PLACE_PRIZE) + (fourthPlaceCount * FOURTH_PLACE_PRIZE) +
                (thirdPlaceCount * THIRD_PLACE_PRIZE) + (secondPlaceCount * SECOND_PLACE_PRIZE) +
                (firstPlaceCount * FIRST_PLACE_PRIZE);
    }

    private void calculateEarningRate(Integer numberOfLottos) {
        earningRate = (prize / (numberOfLottos * STANDARD_UNIT) * 100) - 100;
    }

    public Integer getPrize() {
        return prize;
    }

    public float getEarningRate() {
        return earningRate;
    }
}
