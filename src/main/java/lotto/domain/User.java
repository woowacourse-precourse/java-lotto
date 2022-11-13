package lotto.domain;

import lotto.domain.lotto.Lotto;
import lotto.io.InputControl;
import lotto.io.OutputControl;

public class User {

    public PurchaseAmount inputPurchaseAmount() {
        return new PurchaseAmount(InputControl.readLong());
    }
}
