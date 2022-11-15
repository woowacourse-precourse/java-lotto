package lotto.domain;

import lotto.validator.LottoValidator;
import lotto.validator.MoneyValidator;

import java.util.List;

import static lotto.util.Const.*;

public class User {

    private final long inputMoney;
    private List<Lotto> lottos;

    public User(long inputMoney, List<Lotto> lottos) {
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
        MoneyValidator.check(inputMoney);
        lottos.stream()
                .map(Lotto::getNumbers)
                .forEach(LottoValidator::check);
    }

    public long getQuantity() {
        return inputMoney / LOTTO_PRICE_UNIT;
    }
}
