package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private final LottoMachine lottoMachine = new LottoMachine();
    private final OutputView outputView = new OutputView();
    private List<Lotto> lottos = new ArrayList<>();
    WinningLotto winningLotto;

    public void start() {
        try {
            final int money = new Money(new InputView().inputMoney()).getMoney();
            outputView.printPurchaseLottoCount(money);
            lottos = lottoMachine.ticketLottos(money);
            outputView.printLottos(lottos);
            winningLotto = inputWinningAndBonusNumber();

            showStatistics(lottos, winningLotto, money);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    private void showStatistics(List<Lotto> lottos, WinningLotto winningLotto, int money) {
        Statistics lottoStatistics = new Statistics(lottos, winningLotto);
        outputView.printStatistics(lottoStatistics);
        outputView.printYield(lottoStatistics, money);
    }

    private WinningLotto inputWinningAndBonusNumber() {
        List<String> winningNumbers = new InputView().inputWinningNumber();
        WinningLotto winningLotto = new WinningLotto(winningNumbers);

        String bonusBall = new InputView().inputBonusBall();
        winningLotto.pickBonusBall(bonusBall);

        return winningLotto;
    }
}
