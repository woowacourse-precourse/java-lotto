package lotto.domain;

import lotto.util.LottoGenerator;
import lotto.util.Output;
import lotto.util.Validator;

import java.util.ArrayList;
import java.util.List;

public class User {
    private static final String NOT_POSITIVE_MONEY = "[ERROR] 구입 금액은 0보다 큰 숫자여야 합니다.";
    private static final String INVALID_MONEY_UNIT = "[ERROR] 구입 금액은 1000원 단위여야 합니다.";
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
            throw new IllegalArgumentException(NOT_POSITIVE_MONEY);
        }
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

    public void printLottos() {
        Output.printBuyMessage(lottos.size());
        lottos.forEach(Lotto::print);
    }
}
