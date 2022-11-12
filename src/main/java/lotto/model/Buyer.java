package lotto.model;

import java.util.List;
import lotto.util.Validator;

public class Buyer {
    private int money;
    private Lotto lotto;
    private Validator validator = new Validator();

    public void makeMoney(int money) {
        validator.validateUnit(money);
        this.money = money;
    }

    public void buyLottor(List<Integer> numbers, int bonusNumber) {
        this.lotto = new Lotto(numbers, bonusNumber);
    }

    public int getMoney() {
        return this.money;
    }
}
