package lotto.domain;

import java.util.*;

public class Calculator {

    private List<List<Integer>> myLotto;
    private Lotto winningLotto;
    private BonusNumber bonusNumber;

    private EnumMap<Prize, Integer> result;

    public Calculator(List<List<Integer>> myLotto, Lotto winningLotto, BonusNumber bonusNumber) {
        this.myLotto = myLotto;
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
        result = new EnumMap<>(Prize.class);
    }

    public EnumMap<Prize, Integer> saveResult() {
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

    public Prize compareNumbers(int index) {
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

    public float caculateRate(PurchaseAmount purchaseAmount) {
        int sum = 0;
        Prize[] allPrize = Prize.values();
        for (Prize prize : allPrize) {
            sum = sum + result.get(prize) * prize.money;
        }
        return purchaseAmount.calculateRate(sum);
    }
}
