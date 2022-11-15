package lotto;

import lotto.domain.LottoResult;
import lotto.domain.UserLottos;
import lotto.domain.WinningLotto;
import lotto.view.Input;
import lotto.view.Output;

import java.util.List;

public class Controller {
    private final Input input = new Input();
    private final Output output = new Output();

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
