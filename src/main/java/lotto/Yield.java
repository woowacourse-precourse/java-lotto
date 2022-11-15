package lotto;

import java.text.DecimalFormat;

public class Yield {
    private final String yield;

    public Yield(int netIncome, int purchaseAmount) {
        this.yield = yieldCalculation(netIncome,purchaseAmount);
    }

    private String yieldCalculation(int netIncome, int purchaseAmount) {
        String result;
        float netIncomeAmount = netIncome-purchaseAmount;
        float dividedNetIncomeAmount = netIncomeAmount/purchaseAmount;
        float yieldNum = dividedNetIncomeAmount*100;
        if (yieldNum < 0) {
            yieldNum = yieldNum + 100;
        }
        result = String.format("%,.1f", yieldNum);
        System.out.println("총 수익률은 " + result + "%입니다.");
        return result;
    }
}
