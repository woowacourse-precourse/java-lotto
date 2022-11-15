package lotto.calculate;

import lotto.grade.Grade;

public class RateOfReturn {
    private double sumOfPrize;
    private final CountNumberOfWins countNumberOfWins;

    public RateOfReturn(CountNumberOfWins countNumberOfWins) {
        this.sumOfPrize = 0;
        this.countNumberOfWins = countNumberOfWins;
    }

    public void calculateSumOfPrize() {
        sumOfPrize += (Grade.FIRST.getPrizeMoney() * countNumberOfWins.getFirstPlace());
        sumOfPrize += (Grade.SECOND.getPrizeMoney() * countNumberOfWins.getSecondPlace());
        sumOfPrize += (Grade.THIRD.getPrizeMoney() * countNumberOfWins.getThirdPlace());
        sumOfPrize += (Grade.FOURTH.getPrizeMoney() * countNumberOfWins.getFourthPlace());
        sumOfPrize += (Grade.FIFTH.getPrizeMoney() * countNumberOfWins.getFifthPlace());
    }

    public double getRateOfReturn() {
        return Math.round(( sumOfPrize / countNumberOfWins.setLottoPrice() * 100 * 10)) / 10.0;
    }
}
