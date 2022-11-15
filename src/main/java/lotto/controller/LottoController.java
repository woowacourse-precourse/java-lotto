package lotto.controller;

import lotto.domain.LottoAnswer;
import lotto.domain.User;
import lotto.domain.vo.BuyLotto;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.service.WinningCheck;

import java.util.List;

public class LottoController {
    InputView inputView;
    OutputView outputView;

    public LottoController() {
        outputView = new OutputView();
        inputView = new InputView();
    }

    public void run() {
        BuyLotto buyLotto = buyLottoTicket();
        User user = new User(buyLotto.lottoTicketsCount());
        LottoAnswer lottoAnswer = outputSuccessInputLottoAnswer(user);

        WinningCheck winningCheck = new WinningCheck(user.getUserLottos(), lottoAnswer);
        outputView.outputWinningResults(winningCheck.getLottoResult(), winningCheck.calculate(buyLotto.getMoney()));
    }

    private BuyLotto buyLottoTicket() {
        return new BuyLotto(outputView.outputEnterMoney());
    }

    private LottoAnswer outputSuccessInputLottoAnswer(User user) {
        outputView.outputPurchaseSuccess(user.getUserLottos());
        List<Integer> numbers = outputView.outputEnterLottoAnswer();
        return new LottoAnswer(numbers, outputView.outputEnterBonusNumber());
    }

}
