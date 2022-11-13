package lotto.domain;

import lotto.constant.Constant;
import lotto.constant.Message;
import lotto.util.Validator;

public class User {

    private int money;
    private int nLottoTickets;

    public User(int money){
        validateMoney(money);
        setMoney(money);

        setnLottoTickets(money);
    }

    private void validateMoney(int money) {
        if(!Validator.isLottoMoney(money)){
            Message.printInputErrorUserMoney();
            throw new IllegalArgumentException();
        }
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
