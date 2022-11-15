package lotto;

import lotto.domain.LottoResult;
import lotto.domain.UserLotto;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void startLottoGame() {
        try {
            UserLotto userLotto = buyLotto();
            WinningLotto winningLotto = publishWinningLotto();
            printTotalLottoResult(userLotto.getUserMoney(),userLotto,winningLotto);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private UserLotto buyLotto() {
        UserLotto userLotto = inputView.inputUserMoney();
        outputView.printCountOfPurchasedLotto(userLotto);
        outputView.printSortedLottos(userLotto);
        return userLotto;
    }

    private WinningLotto publishWinningLotto() {
        List<Integer> winningNumbers = inputView.inputWinningNumbers();
        int bonusNumber = inputView.inputBonusNumber();
        return new WinningLotto(winningNumbers, bonusNumber);
    }

    private void printTotalLottoResult(int userMoney, UserLotto userLotto, WinningLotto winningLotto) {
        LottoResult lottoResult = new LottoResult(userMoney, userLotto, winningLotto);
        outputView.printLottoResult(lottoResult);
        outputView.printLottoProfit(lottoResult);
    }
}
