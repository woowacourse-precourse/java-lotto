package lotto.domain;

import lotto.util.Prize;

import java.util.*;

public class Calculator {

    private static List<List<Integer>> myLotto;
    private static Lotto winningLotto;
    private static BonusNumber bonusNumber;
    private static EnumMap<Prize, Integer> result;

    public static void setCalculator(List<List<Integer>> myLotto1, Lotto winningLotto1, BonusNumber bonusNumber1) {
        myLotto = myLotto1;
        winningLotto = winningLotto1;
        bonusNumber = bonusNumber1;
        result = new EnumMap<>(Prize.class);
    }

    public static EnumMap<Prize, Integer> saveResult() {
        int[] count = {0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0; i < myLotto.size(); i++) {
            if (compareNumbers(i) != null) {
                count[compareNumbers(i).sameNumbers]++;
                result.put(compareNumbers(i), count[compareNumbers(i).sameNumbers]);
            }
        }
        Prize[] allPrize = Prize.values();
        for (Prize prize : allPrize) {
            if(!result.containsKey(prize)){
                result.put(prize, 0);
            }
        }
        return result;
    }

    public static Prize compareNumbers(int index) {
        int count = 0;
        for (int j = 0; j < 6; j++) {
            if (winningLotto.contains(myLotto.get(index).get(j))) {
                count++;
            }
        }
        if (count == 5 && bonusNumber.isIn(myLotto.get(index))) {
            count = 7;
        }
        Prize[] allPrize = Prize.values();
        for (Prize prize : allPrize) {
            if (count == prize.sameNumbers) {
                return prize;
            }
        }
        return null;
    }

    public static float calculateRate(PurchaseAmount purchaseAmount) {
        int sum = 0;
        Prize[] allPrize = Prize.values();
        for (Prize prize : allPrize) {
            sum = sum + result.get(prize) * prize.money;
        }
        return purchaseAmount.calculateRate(sum);
    }
}
