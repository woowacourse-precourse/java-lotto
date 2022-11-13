package lotto.controller;

import java.util.List;
import lotto.model.Buyer;
import lotto.model.LottoStatics;
import lotto.model.LottoStore;
import lotto.view.BuyerView;

public class LottoStoreController {
    private final BuyerView input;

    public LottoStoreController() {
        this.input = new BuyerView();
    }

    public void run() {
        Buyer buyer = createBuyer();
        buyer.printBuyLottos();

        LottoStore store = createLottoStore();
        LottoStatics statics = new LottoStatics();
        statics.calculateStatics(buyer, store);
        statics.printStatics();
    }

    private Buyer createBuyer() {
        int money = input.inputMoney();
        return new Buyer(money);
    }

    private LottoStore createLottoStore() {
        List<Integer> lotteryNumbers = input.inputNumbers();
        int bonusNumber = input.inputBonusNumber();
        return new LottoStore(lotteryNumbers, bonusNumber);
    }
}
