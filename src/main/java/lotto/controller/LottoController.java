package lotto.controller;

import lotto.domain.LottoMachine;
import lotto.domain.Lottos;
import lotto.domain.PrizeNumebers;
import lotto.domain.PurchaseMoney;

import java.util.List;

import static lotto.view.Input.*;
import static lotto.view.Output.*;

public class LottoController {

    public void start() {
        try {
            PurchaseMoney purchaseMoney = createPurchaseMoney();
            Lottos lottos = createLottos(purchaseMoney);
            printLottos(lottos);
            PrizeNumebers prizeNumebers = createPrizeNumbers();

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

    private void printLottos(Lottos lottos) {
        printLottosCount(lottos.getLottosCount());
        printLottosInfo(lottos);
    }

    private PrizeNumebers createPrizeNumbers() {
        List<Integer> prizeNumbers = insertPrizeNumbers();
        Integer bonusNumber = insertBonusNumber();
    }
}
