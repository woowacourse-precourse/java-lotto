package lotto.controller;

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
        } catch (RuntimeException e) {
            return;
        }
    }

    private LottoPurchaseMoney createLottoPurchaseMoney() {
        try {
            int money = InputView.lottoPurchaseMoney();
            return new LottoPurchaseMoney(money);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            throw new RuntimeException();
        }
    }

    private PlayerLotto createPlayerLotto(LottoPurchaseMoney lottoPurchaseMoney) {
        try {
            return new PlayerLotto(lottoPurchaseMoney);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            throw new RuntimeException();
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
            OutputView.printErrorMessage(e.getMessage());
            throw new RuntimeException();
        }
    }
}
