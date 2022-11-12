package lotto.controller;

import lotto.domain.LottoPurchaseMoney;
import lotto.domain.PlayerLotto;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoGameController {

    public void playGame() {
        LottoPurchaseMoney lottoPurchaseMoney = createLottoPurchaseMoney();

        PlayerLotto playerLotto = createPlayerLotto(lottoPurchaseMoney);
        printPlayerLotto(playerLotto);

        WinningLotto winningLotto = createWinningLotto();
    }

    private LottoPurchaseMoney createLottoPurchaseMoney() {
        int money = InputView.lottoPurchaseMoney();
        return new LottoPurchaseMoney(money);
    }

    private PlayerLotto createPlayerLotto(LottoPurchaseMoney lottoPurchaseMoney) {
        return new PlayerLotto(lottoPurchaseMoney);
    }

    private void printPlayerLotto(PlayerLotto playerLotto) {
        OutputView.printLottos(playerLotto.getLottos());
    }

    private WinningLotto createWinningLotto() {
        List<Integer> winningNumbers = InputView.winningNumbers();
        int bonusNumber = InputView.bonusNumber();

        return new WinningLotto(winningNumbers, bonusNumber);
    }
}
