package lotto.model;

import lotto.domain.WinningRank;

public class LottoResult {

    private int firstCount;
    private int secondCount;
    private int thirdCount;
    private int fourthCount;
    private int fifthCount;
    private double profit;

    public void refreshResult(WinningRank winningRank) {

        if (winningRank == WinningRank.FIRST) {
            firstCount++;
        } else if (winningRank == WinningRank.SECOND) {
            secondCount++;
        } else if (winningRank == WinningRank.THIRD) {
            thirdCount++;
        } else if (winningRank == WinningRank.FOURTH) {
            fourthCount++;
        } else if (winningRank == WinningRank.FIFTH) {
            fifthCount++;
        }
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    public int getFirstCount() {
        return firstCount;
    }

    public int getSecondCount() {
        return secondCount;
    }

    public int getThirdCount() {
        return thirdCount;
    }

    public int getFourthCount() {
        return fourthCount;
    }

    public int getFifthCount() {
        return fifthCount;
    }
}
