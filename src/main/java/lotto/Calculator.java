package lotto;

import java.util.Arrays;

public class Calculator {

    static private long income = 0;
    static private long[] placesCount = new long[6];
    long money;
    long quantity;
    Calculator(long money) {
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

    static void printResult() {
        Message.CORRECT_THREE.printResult(placesCount[5]);
        Message.CORRECT_FOUR.printResult(placesCount[4]);
        Message.CORRECT_FIVE.printResult(placesCount[3]);
        Message.CORRECT_FIVE_BONUS.printResult(placesCount[2]);
        Message.CORRECT_SIX.printResult(placesCount[1]);
    }
}
