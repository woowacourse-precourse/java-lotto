package lotto;

import java.util.ArrayList;
import java.util.List;

public class Seller {

    private static final int LOTTO_PRICE = 1000;

    public List<Lotto> issueLottos(int money) {
        return issueRandomLottos(amountToIssue(money));
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
