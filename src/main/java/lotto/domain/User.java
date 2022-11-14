package lotto.domain;

import lotto.constant.Constant;
import lotto.constant.Message;
import lotto.util.Validator;

public class User {

    private int money;
    private int nLottoTickets;

    public User(int money){
        setMoney(money);

        setnLottoTickets(money);
    }

    private void setMoney(int money) {
        this.money = money;
    }

    private void setnLottoTickets(int money) {
        this.nLottoTickets = money / Constant.LOTTO_PRICE;
    }

    public int getMoney() {
        return money;
    }

    public int getnLottoTickets() {
        return nLottoTickets;
    }
}
