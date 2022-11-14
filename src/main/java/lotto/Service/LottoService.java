package lotto.Service;

import lotto.Domain.Validator;
import lotto.View.InputView;

public class LottoService {

    public int getPurchaseAmount() {
        return getValidatePurchaseAmout();
    }

    public int getValidatePurchaseAmout() {
        int money = InputView.inputPurchaseAmount();
        return Validator.checkIsValidateAmount(money);
    }
}
