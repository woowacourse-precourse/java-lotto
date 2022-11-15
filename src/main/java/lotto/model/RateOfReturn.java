package lotto.model;

import lotto.view.FinalResult;

public class RateOfReturn {
    private static double inputMoney;
    private static double outputMoney;
    private static double rate;


    public static String rate(){
        inputMoney = Money.money;
        System.out.println("inputMoney" + inputMoney);
        outputMoney = RateOfReturn.getOutputMoney();
        System.out.println("outputMoney" + outputMoney);

        rate = (outputMoney/inputMoney)*100;
        System.out.println("rate" + rate);

        return String.format("%.1f",rate);
    }

    private static double getOutputMoney(){
        System.out.println(FinalResult.fifth);
        return  FinalResult.first * 2000000000
                + FinalResult.second * 30000000
                + FinalResult.third * 1500000
                + FinalResult.fourth * 50000
                + FinalResult.fifth * 5000 ;
    }
}
