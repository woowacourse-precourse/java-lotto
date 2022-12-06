package lotto.domain;

import lotto.util.Prize;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;

import static lotto.util.NumericProperties.SIZE;

public class Calculator {

    private static List<List<Integer>> myLotto;
    private static Lotto winningLotto;
    private static EnumMap<Prize, Integer> result;

    public static void setCalculator(List<List<Integer>> tmpMyLotto, Lotto tmpWinningLotto) {
        myLotto = tmpMyLotto;
        winningLotto = tmpWinningLotto;
        result = new EnumMap<>(Prize.class);
    }

    public static EnumMap<Prize, Integer> calculateResult() {
        List<Prize> count = new ArrayList<>();
        for (int i = 0; i < myLotto.size(); i++) {
            count.add(Prize.getPrize(i, myLotto));
        }
        Prize[] allPrize = Prize.values();
        for (Prize prize : allPrize) {
            result.put(prize, Collections.frequency(count, prize));
        }
        return result;
    }

    public static int countSameNumbers(int index) {
        int count = 0;
        for (int j = 0; j < SIZE.get(); j++) {
            if (winningLotto.contains(myLotto.get(index).get(j))) {
                count++;
            }
        }
        return count;
    }
}
