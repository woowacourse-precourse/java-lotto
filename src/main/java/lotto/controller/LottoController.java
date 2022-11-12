package lotto.controller;

import lotto.domain.LottoMachine;
import lotto.domain.Lottos;
import lotto.domain.PurchaseMoney;

import static lotto.view.Input.*;
import static lotto.view.Output.*;

public class LottoController {

    public void start() {
        try {
            PurchaseMoney purchaseMoney = createPurchaseMoney();
            Lottos lottos = createLottos(purchaseMoney);

        } catch (IllegalArgumentException error) {
            printErrorMessage(error.getMessage());
        }
    }

    private PurchaseMoney createPurchaseMoney() {
        return new PurchaseMoney(insertPurchaseMoney());
    }

    private Lottos createLottos(PurchaseMoney purchaseMoney) {
        LottoMachine lottoMachine = new LottoMachine();
        Lottos lottos = lottoMachine.purchase(purchaseMoney);

        return lottos;
    }
}
