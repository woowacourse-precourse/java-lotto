package lotto;

import java.util.ArrayList;
import java.util.List;

public class Seller {

    private static final int LOTTO_PRICE = 1000;

    public List<Lotto> issueLottos(Money money) {
        validateNoChange(money);
        return issueRandomLottos(money.countAffordableFor(LOTTO_PRICE));
    }

    private void validateNoChange(Money money) {
        if (money.hasChangesWith(LOTTO_PRICE)) {
            throw new IllegalArgumentException("금액이 나눠 떨어지지 않습니다");
        }
    }

    private List<Lotto> issueRandomLottos(int amount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            lottos.add(Lotto.createRandomized());
        }
        return lottos;
    }
}
