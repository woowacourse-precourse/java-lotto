package lotto;

import static lotto.utils.RandomUtil.createRandomNumbers;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private static final int MIN_MONEY = 1000;
    private static final String MIN_MONEY_ERROR_MESSAGE = "[ERROR] 구입금액은 1000원 이상부터 가능합니다.";
    private static final String MONEY_UNIT_ERROR_MESSAGE = "[ERROR] 구입금액은 1000원 단위만 가능합니다.";

    private int money;

    public LottoMachine() {
    }

    public void inputMoney(int money) {
        validate(money);
        this.money = money;
    }

    public List<Lotto> publishLotto() {
        List<Lotto> allLotto = new ArrayList<>();

        while (money != 0) {
            allLotto.add(new Lotto(createRandomNumbers()));
            spendMoney();
        }

        return allLotto;
    }

    private void spendMoney() {
        money -= MIN_MONEY;
    }

    private void validate(int money) {
        validateMinMoney(money);
        validateMoneyUnit(money);
    }

    private void validateMinMoney(int money) {
        if (money < MIN_MONEY) {
            throw new IllegalArgumentException(MIN_MONEY_ERROR_MESSAGE);
        }
    }

    private void validateMoneyUnit(int money) {
        if (isNotValidMoneyUnit(money)) {
            throw new IllegalArgumentException(MONEY_UNIT_ERROR_MESSAGE);
        }
    }

    private boolean isNotValidMoneyUnit(int money) {
        return money % MIN_MONEY != 0;
    }
}
