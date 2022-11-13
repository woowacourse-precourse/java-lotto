package lotto.domain;

import lotto.domain.lotto.WinningLotto;
import lotto.io.InputControl;

public class User {

    public PurchaseAmount inputPurchaseAmount() {
        return new PurchaseAmount(InputControl.readInt());
    }

    public WinningLotto inputLottoNum() {
        return new WinningLotto(InputControl.readInts(","));
    }
}
