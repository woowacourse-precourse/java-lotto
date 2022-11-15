package lotto.model;

import lotto.util.Utils;
import lotto.util.validator.MoneyValidator;

public class MoneyService {
    private String money;

    public MoneyService(String money) {
        new MoneyValidator(money);
        this.money = money;
    }

    public int getLottoCount() {
        return (Utils.convertToInt(money) / 1000);
    }

    public int getMoney() {
        return Utils.convertToInt(money);
    }
}
