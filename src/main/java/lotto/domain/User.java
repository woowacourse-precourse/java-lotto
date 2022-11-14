package lotto.domain;

import lotto.constant.Constant;
import lotto.constant.Message;
import lotto.util.UserInput;

public class User {

    private int money;
    private int nLottoTickets;

    public User(){
        Message.printInputUserMoney();
        setMoney();

        setnLottoTickets();
    }

    private void setMoney() {
        this.money = UserInput.getMoney();
    }

    private void setnLottoTickets() {
        this.nLottoTickets = this.money / Constant.LOTTO_PRICE;
    }
}
