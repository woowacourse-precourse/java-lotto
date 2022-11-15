package lotto;

import lotto.domain.LottoResult;
import lotto.domain.UserLottos;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class Controller {
    private final InputView input = new InputView();
    private final OutputView output = new OutputView();

    public void generate() {
        try {
            int money = input.getMoney();
            UserLottos userLottos = new UserLottos(money);
            output.printUserLottos(userLottos);

            WinningLotto winningLotto = getWinningLotto();

            LottoResult lottoResult = new LottoResult(userLottos, winningLotto);
            output.printResult(lottoResult);

        } catch (IllegalArgumentException e) {
            output.printErrorMessage(e.getMessage());
        }

    }

    public WinningLotto getWinningLotto() {
        List<Integer> winningNumbers = input.getWinningNumbers();
        int bonusNumber = input.getBonusNumbers();

        return new WinningLotto(winningNumbers, bonusNumber);
    }

}
