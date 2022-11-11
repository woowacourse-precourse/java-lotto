package lotto.model;

import lotto.util.Utils;
import lotto.util.validator.MoneyValidator;

public class GetMoneyService {
    private String money;

    public GetMoneyService(String money) {
        new MoneyValidator(money);
        this.money = money;
    }

    public int getLottoCount() {
        return (Utils.stringToIntMoney(money) / 1000);
    }
}
