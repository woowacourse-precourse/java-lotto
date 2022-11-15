package lotto.domain;

import lotto.error.ErrorMessage;
import lotto.util.LottoGenerator;
import lotto.util.Validator;

import java.util.ArrayList;
import java.util.List;

public class User {
    public final List<Lotto> lottos;

    public User(int money) {
        validate(money);
        this.lottos = buyLottos(money / 1000);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    private static void validate(int money) {
        if (!Validator.isPositive(money)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_POSITIVE_MONEY.getMessage());
        }
        if (!Validator.isHundredUnit(money)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_MONEY_UNIT.getMessage());
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
