package lotto.domain;

import lotto.constant.Constant;
import lotto.constant.Message;
import lotto.util.Converter;
import lotto.util.UserInput;

public class User {

    private LottoMoney lottoMoney;
    private int nLottoTickets;

    public User(){
        Message.printInputUserLottoMoney();
        setLottoMoney();
        Message.printNextLine();

        setnLottoTickets();
    }

    private void setLottoMoney() {
        String inputLottoMoney = UserInput.getInputLottoMoney();
        int lottoMoney = Converter.StringToInteger(inputLottoMoney);

        this.lottoMoney = new LottoMoney(lottoMoney);
    }

    private void setnLottoTickets() {
        this.nLottoTickets = this.lottoMoney.getMoney() / Constant.LOTTO_PRICE;
    }

    public int getLottoMoney() {
        return lottoMoney.getMoney();
    }

    public int getnLottoTickets() {
        return nLottoTickets;
    }
}
