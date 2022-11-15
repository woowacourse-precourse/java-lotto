package lotto;

import java.util.HashMap;

import constant.Message;

public class Printer {
    private HashMap<Integer, Integer> winningChart;
    private double rateOfProfit;
    private int moneyInput;

    public Printer(int moneyInput, HashMap<Integer, Integer> winningChart) {
        this.moneyInput = moneyInput;
        this.winningChart = winningChart;
        this.rateOfProfit = 0;

        calculateRateOfReturn();
    }

    private void calculateRateOfReturn() {
        rateOfProfit = winningChart.get(Message.RANKFIRST) * 2000000000
                        + winningChart.get(Message.RANKSECOND) * 30000000
                        + winningChart.get(Message.RANKTHIRD) * 1500000
                        + winningChart.get(Message.RANKFOURTH) * 50000
                        + winningChart.get(Message.RANKFIFTH) * 5000;
    }
}
