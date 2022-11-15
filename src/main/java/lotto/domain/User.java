package lotto.domain;

import lotto.constant.Constant;
import lotto.constant.Message;
import lotto.domain.model.UserMoney;
import lotto.util.Converter;
import lotto.util.UserInput;

public class User {

    private UserMoney userMoney;
    private int nLottoTickets;

    public User(){
        Message.printInputUserMoney();
        setUserMoney();
        Message.printNextLine();

        setnLottoTickets();
    }

    private void setUserMoney() {
        String inputUserMoney = UserInput.getInputUserMoney();
        int userMoney = Converter.StringToInteger(inputUserMoney);

        this.userMoney = new UserMoney(userMoney);
    }

    private void setnLottoTickets() {
        this.nLottoTickets = this.userMoney.getMoney() / Constant.LOTTO_PRICE;
    }

    public int getUserMoney() {
        return userMoney.getMoney();
    }

    public int getnLottoTickets() {
        return nLottoTickets;
    }
}
