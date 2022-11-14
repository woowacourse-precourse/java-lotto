package lotto.domain;

import lotto.ui.LottoGenerator;
import lotto.ui.Validator;

import java.util.ArrayList;
import java.util.List;

public class User {
    private static final String INVALID_MONEY_UNIT = "[ERROR] 구입 금액은 1000원 단위여야 합니다.";
    private final int money;
    private final List<Lotto> lottos;

    public User(int money) {
        validate(money);
        this.money = money;
        this.lottos = buyLottos(money / 1000);
    }

    private static void validate(int money) {
        if (!Validator.isHundredUnit(money)) {
            throw new IllegalArgumentException(INVALID_MONEY_UNIT);
        }
    }

    private static List<Lotto> buyLottos(int amount) {
        List<Lotto> boughtLottos = new ArrayList<>();

        for (int count = 0; count < amount; count++) {
            boughtLottos.add(new Lotto(LottoGenerator.generate()));
        }

        return boughtLottos;
    }
}
