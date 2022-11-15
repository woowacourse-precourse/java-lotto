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
        this.rateOfProfit = Message.ZEROINIT;

        calculateRateOfReturn();
        printWinningChart();
    }

    private void calculateRateOfReturn() {
        int sum = winningChart.get(Message.RANKFIRST) * Message.RANKFIRSTRIZEMONEY
                + winningChart.get(Message.RANKSECOND) * Message.RANKSECONDRIZEMONEY
                + winningChart.get(Message.RANKTHIRD) * Message.RANKTHIRDRIZEMONEY
                + winningChart.get(Message.RANKFOURTH) * Message.RANKFOURTHRIZEMONEY
                + winningChart.get(Message.RANKFIFTH) * Message.RANKFIFTHPRIZEMONEY;

        rateOfProfit = (double) sum / (double) moneyInput * Message.HUNDRED;
    }

    private void printWinningChart() {
        System.out.println(Message.WinStatistics);

        System.out.println(Message.RankFifthMessage + winningChart.get(Message.RANKFIFTH) + Message.Piece);
        System.out.println(Message.RankFourthMessage + winningChart.get(Message.RANKFOURTH) + Message.Piece);
        System.out.println(Message.RankThirdMessage + winningChart.get(Message.RANKTHIRD) + Message.Piece);
        System.out.println(Message.RankSecondMessage + winningChart.get(Message.RANKSECOND) + Message.Piece);
        System.out.println(Message.RankFirstMessage + winningChart.get(Message.RANKFIRST) + Message.Piece);

        System.out.println(Message.RateOfProfitMessage + String.format("%.1f", rateOfProfit) + Message.Description);
    }

}
