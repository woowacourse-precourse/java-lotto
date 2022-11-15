package lotto.domain.model;

import lotto.constant.Message;
import lotto.util.Validator;

public class UserMoney {
    private final int money;

    public UserMoney(int money){
        validateMoney(money);
        this.money = money;
    }

    private void validateMoney(int money) {
        if(!Validator.isNotZeroUserMoney(money)){
            Message.printInputErrorUserMoney();
            throw new IllegalArgumentException();
        }

        if(!Validator.isUserMoney(money)){
            Message.printInputErrorUserMoney();
            throw new IllegalArgumentException();
        }
    }

    public int getMoney() {
        return money;
    }
}
