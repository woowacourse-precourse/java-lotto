package lotto.domain;

public class RateOfProfit {

    public static Long profit() {
        Long profit = 0L;
        Correct[] correctTypes = Correct.values();
        for (Correct correctType : correctTypes) {
            profit += correctType.getPrizeMoney() * correctType.getCnt();
        }
        System.out.println(profit);
        return profit;
    }
    public static double calculate(int amount) {
        return Math.round(profit()/amount*100)/100;
    }
}
