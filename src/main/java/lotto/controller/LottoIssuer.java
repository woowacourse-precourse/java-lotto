package lotto.controller;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;

public enum LottoIssuer {
    INSTANCE;
    public static final int MONEY_UNIT = 1000;

    public static Lotto issue() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(Lotto.MIN_NUMBER, Lotto.MAX_NUMBER, Lotto.NUMBER_SIZE);
        return new Lotto(numbers);
    }

    public static List<Lotto> issue(int money) {
        List<Lotto> lotteries = new ArrayList<>();

        int quantity = countPurchasedLotto(money);
        while (quantity > 0) {
            lotteries.add(issue());
            quantity--;
        }

        return lotteries;
    }

    private static int countPurchasedLotto(int money) {
        return money / MONEY_UNIT;
    }

}
