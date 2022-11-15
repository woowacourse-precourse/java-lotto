package lotto.config;

import lotto.controller.LottoController;
import lotto.service.impl.LottoServiceImpl;
import lotto.validator.impl.BonusNumberInputValidatorImpl;
import lotto.validator.impl.PurchaseAmountInputValidatorImpl;
import lotto.validator.impl.WinningNumberInputValidatorImpl;

public class LottoConfig {

    public static LottoController config() {
        return new LottoController(new LottoServiceImpl(), new BonusNumberInputValidatorImpl(),
            new PurchaseAmountInputValidatorImpl(), new WinningNumberInputValidatorImpl());
    }
}
