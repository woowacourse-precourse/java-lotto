package lotto.domain;

import lotto.utils.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private static final int LOTTO_PRICE = 1000;
    public static final int DIVISIBLE = 0;

    private final List<Lotto> lottos = new ArrayList<>();

    public Lottos(int money) {
        validate(money);
        int issuedCount = money / LOTTO_PRICE;
        for (int i = 0; i < issuedCount; i++) {
            lottos.add(Lotto.creatRandom());
        }
    }

    private void validate(int money) {
        if (isMoneyIndivisibleByPrice(money)) {
            throw new IllegalArgumentException(ErrorMessage.MONEY_LEFT_OVER);
        }
    }

    private static boolean isMoneyIndivisibleByPrice(int money) {
        return money % LOTTO_PRICE != DIVISIBLE;
    }

    public int countTotal() {
        return lottos.size();
    }
}
