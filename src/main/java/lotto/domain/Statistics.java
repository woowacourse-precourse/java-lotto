package lotto.domain;

import java.util.List;

public class Statistics {
    private Statistics(List<List<Integer>> purchasedNumber, int bonus) {

    }

    public static Statistics getInstance(List<List<Integer>> purchasedNumber, int bonusNumber) {
        return new Statistics(purchasedNumber, bonusNumber);
    }
}
