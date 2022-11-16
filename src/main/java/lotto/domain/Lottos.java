package lotto.domain;

import lotto.utils.ErrorMessage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {
    private static final int LOTTO_PRICE = 1000;
    public static final int DIVISIBLE = 0;
    public static final String NEW_LINE = "\n";

    private final List<Lotto> lottos = new ArrayList<>();

    private Lottos(int money) {
        validate(money);
        purchaseRandomLottos(money);
    }

    private void purchaseRandomLottos(int money) {
        int balance = money;
        while (balance >= LOTTO_PRICE) {
            lottos.add(Lotto.creatRandom());
            balance -= LOTTO_PRICE;
        }
    }

    public static Lottos purchaseFor(int money) {
        return new Lottos(money);
    }

    Lottos(Lotto... lottos) {
        Collections.addAll(this.lottos, lottos);
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

    public LottoResult countNumberOfWins(WinningLotto winningLotto) {
        return LottoResult.of(lottos, winningLotto);
    }

    @Override
    public String toString() {
        StringBuilder message = new StringBuilder();

        for (Lotto lotto : lottos) {
            message.append(lotto).append(NEW_LINE);
        }
        return message.toString();
    }
}
