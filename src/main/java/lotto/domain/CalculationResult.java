package lotto.domain;

import java.util.List;
import lotto.utils.Money;
import lotto.view.GameOutput;

public class CalculationResult {

    private final int ZERO_COUNT = 0;
    private int threeMatchCount;
    private int fourMatchCount;
    private int fiveMatchCount;
    private int fivePlusBonusMatchCount;
    private int sixMatchCount;
    private double totalRate;

    public void setCCountZero() {
        threeMatchCount = ZERO_COUNT;
        fourMatchCount = ZERO_COUNT;
        fiveMatchCount = ZERO_COUNT;
        fivePlusBonusMatchCount = ZERO_COUNT;
        sixMatchCount = ZERO_COUNT;
    }

    public void calculateResult(List<List<Integer>> lotteries, int bonusNumber,
            List<Integer> answer) {
        setCCountZero();
        for (List<Integer> lotto : lotteries) {
            int count = (int) lotto.stream()
                    .filter(number -> answer.contains(number))
                    .count();
            setCount(count, lotto.contains(bonusNumber));
        }
        setTotalRate();
    }

    public void setCount(int count, boolean haveBonusNumber) {
        if (count == 3) {
            threeMatchCount++;
        }
        if (count == 4) {
            fourMatchCount++;
        }
        if (count == 5) {
            toFiveMatchCase(haveBonusNumber);
        }
        if (count == 6) {
            sixMatchCount++;
        }
    }

    public void toFiveMatchCase(boolean haveBonusNumber) {
        if (haveBonusNumber) {
            fivePlusBonusMatchCount++;
            return;
        }
        fiveMatchCount++;
    }

    public int calculateTotalPrize() {
        return Money.FIFTH_PRIZE.getMoneyAsInteger() * threeMatchCount
                + Money.FOURTH_PRIZE.getMoneyAsInteger() * fourMatchCount
                + Money.THIRD_PRIZE.getMoneyAsInteger() * fiveMatchCount
                + Money.SECOND_PRIZE.getMoneyAsInteger() * fivePlusBonusMatchCount
                + Money.FIRST_PRIZE.getMoneyAsInteger() * sixMatchCount;
    }

    public double calculateRate(int userInputMoney, int totalPrize) {
        return ((double) totalPrize / (double) userInputMoney) * 100;
    }

    public void setTotalRate() {
        this.totalRate = calculateRate(User.getUserInputMoney(), calculateTotalPrize());
    }

    public void printResult() {
        GameOutput.printWinningStatistics();
        GameOutput.printThreeMatches(Money.FIFTH_PRIZE.getMoney(), threeMatchCount);
        GameOutput.printFourMatches(Money.FOURTH_PRIZE.getMoney(), fourMatchCount);
        GameOutput.printFiveMatches(Money.THIRD_PRIZE.getMoney(), fiveMatchCount);
        GameOutput.printFivePlusBonusMatches(Money.SECOND_PRIZE.getMoney(),
                fivePlusBonusMatchCount);
        GameOutput.printSixMatches(Money.FIRST_PRIZE.getMoney(), sixMatchCount);
        GameOutput.printTotalRate(totalRate);
    }
}
