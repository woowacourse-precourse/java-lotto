package lotto;

import java.util.List;

public class WinningStatisticsResult {
    private final List<Integer> countWinning;
    private final List<LottoWinningEnum> lottoWinningEnum;
    private final double yield;

    public WinningStatisticsResult(List<Integer> countWinning, List<LottoWinningEnum> lottoWinningEnum, int buyPrice) {
        this.countWinning = countWinning;
        this.lottoWinningEnum = lottoWinningEnum;
        this.yield = getYield(buyPrice);
    }

    public String printWinningStatistics(){ //WinningStatistics-print-001
        String message = Message.WINNING_STATISTICS_START_MESSAGE.getMessage();
        for (int index = 0; index < this.countWinning.size(); index++){
            int count = this.countWinning.get(index);
            message = message + this.lottoWinningEnum.get(index).getPrintString(count);
        }
        return message;
    }

    public String printYield(){ // WinningStatistics-yield-001
        String message = Message.WINNING_YIELD_PRINT_FORM.getMessage();
        message = message.replace("%yield",String.valueOf(this.yield));
        return message;
    }

    private double getYield(int buyPrice){ //WinningStatistics-yield-001
        double getPrice = 0;
        for (int index = 0; index < this.countWinning.size(); index++){
            int count = this.countWinning.get(index);
            int money = this.lottoWinningEnum.get(index).getMoney();
            getPrice += count * money;
        }
        double yield = getPrice / buyPrice * 100;
        return Math.round(yield * 10) / 10.0;
    }

}
