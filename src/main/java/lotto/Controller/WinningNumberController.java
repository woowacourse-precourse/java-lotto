package lotto.Controller;

import lotto.Model.Lotto;
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

        String userInput = inputView.readWinningNumber();

        Lotto winningLotto = lottoService.createCustomLotto(userInput);
    }

    public void output() {

    }
}
