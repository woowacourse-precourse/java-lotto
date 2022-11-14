package lotto.controller;

import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    LottoService lottoService = new LottoService();

    public void startLotto() {
        int money = Integer.parseInt(InputView.inputMoney());
        lottoService.buyLotto(money);
    }

    public void initWinningLotto() {
        String winningNumber = InputView.inputWinningNumber();
        lottoService.saveWinningLotto(winningNumber);
    }

    public void showUserLottoInfo() {
        OutputView.printPurchasedLotto(lottoService.getUserLotties().size());
        OutputView.printLottoNumbers(lottoService.getUserLotties());
    }
}
