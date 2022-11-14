package lotto.controller;

import lotto.model.Buyer;
import lotto.model.Lotto;
import lotto.model.LottoStatics;
import lotto.model.LottoStore;
import lotto.model.Money;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoStoreController {
    public void run() {
        Buyer buyer = createBuyer();
        OutputView.printLottos(buyer.getLottos());

        LottoStore store = createLottoStore();

        LottoStatics statics = new LottoStatics();
        statics.calculateStatics(buyer, store);

        OutputView.printWinnings(statics);
        OutputView.printYield(buyer.getMoney(), statics);
    }

    private Buyer createBuyer() {
        Money money = new Money(InputView.inputMoney());
        return new Buyer(money);
    }

    private LottoStore createLottoStore() {
        Lotto lotto = new Lotto(InputView.inputNumbers());
        int bonusNumber = InputView.inputBonusNumber();

        return new LottoStore(lotto, bonusNumber);
    }
}
