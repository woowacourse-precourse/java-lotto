package lotto.Controller;

import lotto.Model.WinningLotto;
import lotto.Service.LottoService;
import lotto.View.InputView;

public class WinningNumberController {
    private static LottoService lottoService = new LottoService();

    public void start() {
        input();
        output();
    }

    public void input() {
        InputView inputView = new InputView();

        String numbers = inputView.readWinningNumber();
        int bonusNumber = inputView.readBonusNumber();

        WinningLotto winningNumbers = lottoService.createWinningLotto(numbers, bonusNumber);
    }

    public void output() {

    }
}
