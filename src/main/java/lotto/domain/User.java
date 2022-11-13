package lotto.domain;

import lotto.domain.lotto.LottoWithBonusNum;
import lotto.io.InputControl;

public class User {

    public PurchaseAmount inputPurchaseAmount() {
        return new PurchaseAmount(InputControl.readInt());
    }

    public LottoWithBonusNum inputLottoNum() {
        return new LottoWithBonusNum(InputControl.readInts(","));
    }
}
