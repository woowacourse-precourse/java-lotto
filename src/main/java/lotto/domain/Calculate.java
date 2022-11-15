package lotto.domain;

public class Calculate {

    public double calculateRateOfProfit(int buyAmount, int winnings) {
        double division = (double) winnings / buyAmount;
        int roundingOff = (int) division * 10000;   // 반올림 하기 위해 100이 아닌 10000을 곱함
        if (roundingOff % 10 >= 5) {    // 반올림
            roundingOff += 10;
        }
        double profit = (double) roundingOff / 100;
        return profit;
    }
}
