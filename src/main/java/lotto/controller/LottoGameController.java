package lotto.controller;

import lotto.domain.LottoGameResult;
import lotto.domain.LottoPurchaseMoney;
import lotto.domain.PlayerLotto;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoGameController {

    public void playGame() {
        try {
            LottoPurchaseMoney lottoPurchaseMoney = createLottoPurchaseMoney();

            PlayerLotto playerLotto = createPlayerLotto(lottoPurchaseMoney);
            printPlayerLotto(playerLotto);

            WinningLotto winningLotto = createWinningLotto();

            LottoGameResult lottoGameResult = createLottoGameResult(playerLotto, winningLotto);
            printLottoGameResult(lottoGameResult, lottoPurchaseMoney);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
        }
    }

    private LottoPurchaseMoney createLottoPurchaseMoney() {
        try {
            int money = InputView.lottoPurchaseMoney();
            return new LottoPurchaseMoney(money);
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    private PlayerLotto createPlayerLotto(LottoPurchaseMoney lottoPurchaseMoney) {
        try {
            return new PlayerLotto(lottoPurchaseMoney);
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    private void printPlayerLotto(PlayerLotto playerLotto) {
        OutputView.printLottos(playerLotto.getLottos());
    }

    private WinningLotto createWinningLotto() {
        try {
            List<Integer> winningNumbers = InputView.winningNumbers();
            int bonusNumber = InputView.bonusNumber();

            return new WinningLotto(winningNumbers, bonusNumber);
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    private LottoGameResult createLottoGameResult(PlayerLotto playerLotto, WinningLotto winningLotto) {
        return new LottoGameResult(playerLotto, winningLotto);
    }

    private void printLottoGameResult(LottoGameResult lottoGameResult, LottoPurchaseMoney lottoPurchaseMoney) {
        OutputView.printTotalResult(lottoGameResult, lottoPurchaseMoney);
    }
}
