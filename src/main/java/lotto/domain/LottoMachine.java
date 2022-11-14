package lotto.domain;

import lotto.io.Input;
import lotto.util.BonusNumberValidator;
import lotto.util.PurchaseAmtValidator;
import lotto.util.WinningNumberValidator;

import java.util.List;

public class LottoMachine {

    private final Input input;
    private final NumberGenerator numberGenerator;

    public LottoMachine() {
        this.input = new Input(new PurchaseAmtValidator(), new WinningNumberValidator(), new BonusNumberValidator());
        this.numberGenerator = new NumberGenerator();
    }

}
