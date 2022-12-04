package domain;

import util.LottoStatus;
import util.MoneyStatus;
import util.WinningStatus;

import java.util.ArrayList;
import java.util.List;

public class Result {
    List<Integer> winningCount;
    String profit;

    public Result() {
        winningCount = new ArrayList<>();
        setWinningCount();
    }

    private void setWinningCount() {
        for (int winningIndex = 0; winningIndex < LottoStatus.WIN_COUNT.getCode(); winningIndex++) {
            winningCount.add(0);
        }
    }

    public void addCount(int winningIndex) {
        winningCount.set(winningIndex, winningCount.get(winningIndex) + 1);
    }

    public int getCount(int winningIndex) {
        return winningCount.get(winningIndex);
    }

    public double getProfit(long amount) {
        long totalMoney = getTotalMoney();
        return roundProfit(calcProfit(amount, totalMoney));
    }

    public double roundProfit(double profit) {
        return Math.round(profit * MoneyStatus.ROUND.getStatus()) / (double) MoneyStatus.ROUND.getStatus();
    }

    public double calcProfit(long amount, long totalMoney) {
        return ((double) totalMoney / amount) * MoneyStatus.PERCENT.getStatus();
    }

    public long getTotalMoney() {
        int totalAmount = 0;

        for(WinningStatus status : WinningStatus.values()) {
            totalAmount += calcMoney(status);
        }
        return totalAmount;
    }

    public long calcMoney(WinningStatus status) {
        return winningCount.get(status.getPointIndex()) * status.getWinningMoney();
    }
}
