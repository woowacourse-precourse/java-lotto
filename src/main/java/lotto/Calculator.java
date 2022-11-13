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
        Message.CORRECT_THREE.printResult(placesCount[5]);
        Message.CORRECT_FOUR.printResult(placesCount[4]);
        Message.CORRECT_FIVE.printResult(placesCount[3]);
        Message.CORRECT_FIVE_BONUS.printResult(placesCount[2]);
        Message.CORRECT_SIX.printResult(placesCount[1]);
        double profit = (double) income / money * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.", profit);
    }
}
