package lotto;

import lotto.Message.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class User {
    int money = 0;
    int lottoQuantity = 0;
    List<Lotto> lotto;

    public User(String money) {
        validate(money);
        this.money = Integer.valueOf(money);
        this.lottoQuantity = Integer.valueOf(money) % 1000;
        this.lotto = new ArrayList<>();
    }

    public void validate(String money) {
        numericValidate(money);
        rangeValidate(money);
    }

    public void numericValidate(String money) {
        try {
            Integer inputMoney = Integer.valueOf(money);
        } catch (NumberFormatException e) {
            ErrorMessage.printNonNumericInputErrorMessage();
            throw new IllegalArgumentException();
        }
    }

    public void rangeValidate(String money) {
        if (Integer.valueOf(money) % 1000 != 0) {
            ErrorMessage.printMoneyInputErrorMessage();
            throw new IllegalArgumentException();
        }
    }

    public void buyLotto() {
        for (int quantity = 0; quantity < this.lottoQuantity; quantity++) {
            Lotto lotto = new Lotto(pickUniqueNumbersInRange(1, 45, 6));
        }
    }
}
