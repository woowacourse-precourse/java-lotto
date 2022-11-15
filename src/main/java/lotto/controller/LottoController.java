package lotto.controller;

import lotto.domain.*;

import java.util.List;

import static lotto.view.Input.*;
import static lotto.view.Output.*;

public class LottoController {

    public void start() {
        try {
            PurchaseMoney purchaseMoney = createPurchaseMoney();

            Lottos lottos = createLottos(purchaseMoney);
            printLottos(lottos);

            TotalPrizeNumbers totalPrizeNumbers = createPrizeNumbers();

            WinningList winningList = createWinningList(lottos, totalPrizeNumbers);
            printWinningList(winningList);
            printRateofProfit(winningList, purchaseMoney);
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


    private TotalPrizeNumbers createPrizeNumbers() {
        List<Integer> prizeNumbers = insertPrizeNumbers();
        Integer bonusNumber = insertBonusNumber(prizeNumbers);

        return new TotalPrizeNumbers(prizeNumbers, bonusNumber);
    }

    private WinningList createWinningList(Lottos lottos, TotalPrizeNumbers totalPrizeNumbers) {
        WinningList winningList = LottoMachine.compute(lottos, totalPrizeNumbers);

        return winningList;
    }
}
