package lotto.domain;

public class RateOfProfit {

    private static double profit;

    public static void profit() {
        CorrectNum[] correctNumTypes = CorrectNum.values();
        for (CorrectNum correctNumType : correctNumTypes) {
            profit += correctNumType.PrizeMoney() * correctNumType.Cnt();
        }
    }

    public static double calculate(int amount) {
        profit();
        double answer = profit / amount * 100.0;
        return Math.round(answer * 100) / 100.0;
    }
}
