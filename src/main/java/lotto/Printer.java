package lotto;

import java.util.HashMap;
import java.util.Map;

import constant.Message;

public class Printer {
    private final Map<Integer, Integer> winningChart;
    private double rateOfProfit;
    private final int moneyInput;

    public Printer(int moneyInput, Map<Integer, Integer> winningChart) {
        this.moneyInput = moneyInput;
        this.winningChart = winningChart;
        this.rateOfProfit = 0;

        calculateRateOfReturn();
        printWinningChart();
    }

    private void calculateRateOfReturn() {
        int sum = winningChart.get(Message.RANKFIRST) * 2000000000
                + winningChart.get(Message.RANKSECOND) * 30000000
                + winningChart.get(Message.RANKTHIRD) * 1500000
                + winningChart.get(Message.RANKFOURTH) * 50000
                + winningChart.get(Message.RANKFIFTH) * 5000;

        rateOfProfit = (double) sum / (double) moneyInput * 100;
    }

    private void printWinningChart() {
        System.out.println("당첨 통계" + "\n" + "---");

        System.out.println(Message.RankFifthMessage + winningChart.get(Message.RANKFIFTH) + Message.Piece);
        System.out.println(Message.RankFourthMessage + winningChart.get(Message.RANKFOURTH) + Message.Piece);
        System.out.println(Message.RankThirdMessage + winningChart.get(Message.RANKTHIRD) + Message.Piece);
        System.out.println(Message.RankSecondMessage + winningChart.get(Message.RANKSECOND) + Message.Piece);
        System.out.println(Message.RankFirstMessage + winningChart.get(Message.RANKFIRST) + Message.Piece);

        System.out.println(Message.RateOfProfitMessage + String.format("%.1f", rateOfProfit) + Message.Description);
    }

}
