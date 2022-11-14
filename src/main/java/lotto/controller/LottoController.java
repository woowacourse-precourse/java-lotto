package lotto.controller;

import lotto.service.LottoService;
import lotto.view.InputView;

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
}
