package lotto.controller;

import lotto.domain.*;
import lotto.dto.LottoGameResultDto;

import static lotto.view.InputView.*;
import static lotto.view.OutputView.*;

public class LottoController {
    public void run() {
        LottoGame lottoGame = buyLotto();
        WinningLotto winningLotto = getWinningLotto(lottoGame);
        BonusNumber bonusNumber = getBonusNumber(lottoGame, winningLotto);
        LottoGameResultDto lottoGameResultDto = lottoGame.play(winningLotto, bonusNumber);
        printLottoGameResult(lottoGameResultDto);
    }

    private LottoGame buyLotto() {
        LottoGame lottoGame = new LottoGame(payMoney());
        printLottoNumbers(lottoGame.getLottoTicket());
        return lottoGame;
    }

    private Customer payMoney() {
        Customer customer = new Customer(inputMoney());
        printLottoQuantity(customer.getBuyLottoQuantity());
        return customer;
    }

    private WinningLotto getWinningLotto(LottoGame lottoGame) {
        return lottoGame.generateWinningLotto(inputWinningNumbers());
    }

    private BonusNumber getBonusNumber(LottoGame lottoGame, WinningLotto winningLotto) {
        String bonusNumber = inputBonusNumber();
        return lottoGame.generateBonusNumber(bonusNumber, winningLotto);
    }
}
