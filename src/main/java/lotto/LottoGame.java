package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.Money;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private final LottoMachine lottoMachine = new LottoMachine();
    private final OutputView outputView = new OutputView();
    private List<Lotto> lottos = new ArrayList<>();

    public void start() {
        int money = new Money(new InputView().inputMoney()).getMoney();
        outputView.printPurchaseLottoCount(money);

        lottos = lottoMachine.ticketLottos(money);
        outputView.printLottos(lottos);
    }
}
