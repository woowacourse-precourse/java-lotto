package lotto.domain;

import lotto.io.Input;
import lotto.util.BonusNumberValidator;
import lotto.util.PurchaseAmtValidator;
import lotto.util.WinningNumberValidator;

public class LottoMachine {

    private final Input input;

    public LottoMachine() {
        this.input = new Input(new PurchaseAmtValidator(), new WinningNumberValidator(), new BonusNumberValidator());
    }

}
