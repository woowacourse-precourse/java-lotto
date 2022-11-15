package lotto.controller;

import lotto.Utils;
import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;


public class LottoController {

    public LottoController() {
    }

    public void run() {
        final Money money = createMoney();
        final UserLottos userLottos = createUserLottos(money.getTicketCount());
        showLottos(money.getTicketCount(), userLottos.get());

        final WinningNums winningNums = createWinningNums();
        final LottoResult lottoResult = createLottoResult(userLottos.get(), winningNums);
        showResult(lottoResult, money.getMoney());
    }

    private Money createMoney() {
        return new Money(InputView.inputMoney());
    }

    private UserLottos createUserLottos(int ticketCount) {
        return new UserLottos(ticketCount);
    }

    private WinningNums createWinningNums() {
        return new WinningNums(InputView.inputWinningNums(), InputView.inputBonusNum());
    }

    private void showLottos(int ticketCount, List<Lotto> lottos) {
        OutputView.printLottos(ticketCount, lottos);
    }

    private LottoResult createLottoResult(List<Lotto> lottos, WinningNums winningNums) {
        return new LottoResult(lottos, winningNums);
    }

    private void showResult(LottoResult result, int money) {
        OutputView.printResult(result.get());
        OutputView.printRateOfReturn(Utils.getRateOfReturn(money, result.getTotalPrize()));
    }
}
