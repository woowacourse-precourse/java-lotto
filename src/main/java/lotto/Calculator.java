package lotto;

import java.util.Arrays;

public class Calculator {

    static private long income;
    static private long[] placesCount;
    long money;
    long quantity;
    Calculator(long money) {
        income = 0;
        placesCount = new long[6];
        this.money = money;
        this.quantity = money / 1000;
        Message.PURCHASE.printPurchase(quantity);
    }

    static void calculateLottos(long count, boolean isBonus) {
        if (count == 5) {
            Arrays.stream(Correct.values())
                    .filter(s -> s.correct == count)
                    .filter(s -> s.isBonusCorrect == isBonus)
                    .peek(s -> placesCount[s.place]++)
                    .forEach(s -> income += s.prize);
            return;
        }
        Arrays.stream(Correct.values())
                .filter(s -> s.correct == count)
                .peek(s -> placesCount[s.place]++)
                .forEach(s -> income += s.prize);
    }

    void printResult() {
        Arrays.stream(Correct.values())
                        .forEach(s -> Message.valueOf(s.name()).printResult(placesCount[s.place]));
        double profit = (double) income / money * 100;
        Message.PROFIT.printProfit(profit);
    }
}
