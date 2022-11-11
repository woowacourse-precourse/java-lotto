package lotto.domain;

import lotto.Utils;

public class Controller {
    Utils utils = new Utils();

    public void run() {
        int money = utils.inputMoney();
        int lottoTicket = utils.countTicket(money);
    }
}