package lotto.game;

import lotto.validator.lottoValidator;
import lotto.validator.moneyValidator;

import java.util.List;

import static lotto.util.Const.*;
public class user {
    private final long inputMoney;
    private List<Lotto> lottos;

    public user(long inputMoney, List<Lotto> lottos) {
        validate(inputMoney, lottos);
        this.inputMoney = inputMoney;
        this.lottos = lottos;
    }

    public long getInputMoney() {
        return inputMoney;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void validate(long inputMoney, List<Lotto> lottos) {
        moneyValidator.check(inputMoney);
        lottos.stream()
                .map(Lotto::getNumbers)
                .forEach(lottoValidator::check);
    }

    public long getQuantity() {
        return inputMoney / LOTTO_PRICE_UNIT;
    }
}
