package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Seller {

    private static final int LOTTO_PRICE = 1000;
    private static final String CHANGES_EXIST_EXCEPTION_MESSAGE = "금액이 나눠 떨어지지 않습니다";

    public List<Lotto> issueLottos(Money money) {
        validateNoChanges(money);
        return issueRandomLottos(money.countAffordableFor(LOTTO_PRICE));
    }

    private void validateNoChanges(Money money) {
        if (money.hasChangesWith(LOTTO_PRICE)) {
            throw new IllegalArgumentException(CHANGES_EXIST_EXCEPTION_MESSAGE);
        }
    }

    private List<Lotto> issueRandomLottos(long count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(Lotto.createRandomized());
        }
        return lottos;
    }
}
