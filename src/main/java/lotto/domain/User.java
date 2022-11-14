package lotto.domain;

import lotto.validator.MoneyValidator;

import java.util.List;

import static lotto.util.Const.*;

public class User {

    private final long inputMoney;
    private List<Lotto> lottos;

    public User(long inputMoney, List<Lotto> lottos) {
        validateMoney(inputMoney);
        this.inputMoney = inputMoney;
        this.lottos = lottos;
    }

    public long getInputMoney() {
        return inputMoney;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void validateMoney(long inputMoney) {
        MoneyValidator.check(inputMoney);
    }

    public long getQuantity() {
        return inputMoney / LOTTO_PRICE_UNIT;
    }
}
