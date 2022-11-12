package lotto.controller;

import lotto.util.Printer;
import lotto.view.LottoMessage;

public class LottoController {
    private Printer printer = new Printer();

    public void init() {
        printer.print(LottoMessage.INPUT_AMOUNT.getMessage());
    }

}
