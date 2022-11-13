package lotto.controller;

import lotto.domain.User;
import lotto.util.Printer;
import lotto.view.LottoMessage;

public class LottoController {
    private Printer printer = new Printer();
    private User user = new User();

    public void init() {
        printer.print(LottoMessage.INPUT_AMOUNT.getMessage());
        sell();
    }

    private void sell() {
        int amount = user.buy();
        int lottoNum = amount / 1000;
        printer.print(lottoNum + LottoMessage.PURCHASE_DONE.getMessage());
    }

}
