package lotto.domain;

import lotto.view.FinalResult;

public class RateOfReturn {
    private static int inputMoney;
    private static int outputMoney;
    private static double rate;

    private static int getOutputMoney(){
        return  FinalResult.first * 2000000000
                + FinalResult.second * 30000000
                + FinalResult.third * 1500000
                + FinalResult.fourth * 50000
                + FinalResult.fourth * 5000 ;

    }

    public static double rate(){
        inputMoney = Money.money;
        outputMoney = RateOfReturn.getOutputMoney();

        rate = (double)outputMoney/inputMoney;

        return Double.parseDouble(String.format("%.2f",rate));
    }
}
