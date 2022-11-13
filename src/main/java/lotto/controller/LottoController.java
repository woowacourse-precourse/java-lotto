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
    }

}
