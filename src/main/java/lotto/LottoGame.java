package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.Money;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private final LottoMachine lottoMachine = new LottoMachine();
    private final OutputView outputView = new OutputView();
    private List<Lotto> lottos = new ArrayList<>();
    WinningLotto winningLotto;

    public void start() throws Exception {
        try {
            final int money = new Money(new InputView().inputMoney()).getMoney();
            outputView.printPurchaseLottoCount(money);

            lottos = lottoMachine.ticketLottos(money);
            outputView.printLottos(lottos);

            winningLotto = inputWinningAndBonusNumber();


        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public WinningLotto inputWinningAndBonusNumber() {
        List<String> winningNumbers = new InputView().inputWinningNumber();
        WinningLotto winningLotto = new WinningLotto(winningNumbers);

        String bonusBall = new InputView().inputBonusBall();
        winningLotto.pickBonusBall(bonusBall);

        return winningLotto;
    }
}
