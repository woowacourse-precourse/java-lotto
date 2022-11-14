package lotto.domain;

import lotto.constant.Constant;
import lotto.constant.Message;
import lotto.util.UserInput;

public class User {

    private int lottoMoney;
    private int nLottoTickets;

    public User(){
        Message.printInputUserLottoMoney();
        setLottoMoney();
        Message.printNextLine();

        setnLottoTickets();
    }

    private void setLottoMoney() {
        this.lottoMoney = UserInput.getLottoMoney();
    }

    private void setnLottoTickets() {
        this.nLottoTickets = this.lottoMoney / Constant.LOTTO_PRICE;
    }

    public int getLottoMoney() {
        return lottoMoney;
    }

    public int getnLottoTickets() {
        return nLottoTickets;
    }
}
