package lotto;

import java.util.ArrayList;
import java.util.List;

public class Seller {

    private static final int LOTTO_PRICE = 1000;

    public List<Lotto> issueLottos(int money) {
        validateGreaterThanZero(money);
        validateNoRemainder(money);
        return issueRandomLottos(amountToIssue(money));
    }

    private void validateGreaterThanZero(int money) {
        if (money < 0) {
            throw new IllegalArgumentException("금액은 음수이면 안됩니다");
        }
    }

    private void validateNoRemainder(int money) {
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("금액이 나눠 떨어지지 않습니다");
        }
    }

    private int amountToIssue(int money) {
        return money / LOTTO_PRICE;
    }

    private List<Lotto> issueRandomLottos(int amount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            lottos.add(Lotto.createRandomized());
        }
        return lottos;
    }
}
