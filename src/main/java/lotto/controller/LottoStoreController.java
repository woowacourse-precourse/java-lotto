package lotto.controller;

import static lotto.view.OutputView.printStatics;
import static lotto.view.OutputView.printYield;

import java.util.List;
import lotto.model.Buyer;
import lotto.model.LottoStatics;
import lotto.model.LottoStore;
import lotto.model.Money;
import lotto.view.InputView;

public class LottoStoreController {
    private final InputView input;

    public LottoStoreController() {
        this.input = new InputView();
    }

    public void run() {
        Buyer buyer = createBuyer();
        buyer.printBuyLottos();

        LottoStore store = createLottoStore();
        LottoStatics statics = new LottoStatics();
        statics.calculateStatics(buyer, store);
        printStatics(statics);
        printYield(buyer, statics);
    }

    private Buyer createBuyer() {
        Money money = new Money(InputView.inputMoney());
        return new Buyer(money);
    }

    private LottoStore createLottoStore() {
        List<Integer> lotteryNumbers = input.inputNumbers();
        int bonusNumber = input.inputBonusNumber();
        return new LottoStore(lotteryNumbers, bonusNumber);
    }
}
