package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Calculator {

    static final private int MAX_NUMBER = 45;
    static final private int MIN_NUMBER = 1;
    static final private int NUMBER_COUNT = 6;
    final private long money;
    final private long quantity;
    static private long income;
    static private long[] placesCount;

    List<List<Integer>> lotteries = new ArrayList<>();

    Calculator(long money) {
        income = 0;
        placesCount = new long[6];
        this.money = money;
        this.quantity = money / 1000;
        Message.PURCHASE.printPurchase(quantity);
        generateRandomLotto(quantity);
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

    void generateRandomLotto(long quantity) {
        for (int i = 0; i < quantity; i++) {
            List<Integer> randomLotto =
                    new ArrayList<>(Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, NUMBER_COUNT));
            randomLotto.sort(Comparator.naturalOrder());
            lotteries.add(randomLotto);
            printLotto(randomLotto);
        }
    }

    void printLotto(List randomLotto) {
        System.out.println(randomLotto);
    }
}
