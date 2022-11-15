package lotto.domain;

import lotto.constant.Message;
import lotto.util.Validator;

public class LottoMoney {
    private final int money;

    public LottoMoney(int money){
        validateMoney(money);
        this.money = money;
    }

    private void validateMoney(int money) {
        if(!Validator.isLottoMoney(money)){
            Message.printInputErrorUserLottoMoney();
            throw new IllegalArgumentException();
        }
    }

    public int getMoney() {
        return money;
    }
}
