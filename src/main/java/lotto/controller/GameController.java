package lotto.controller;

import java.util.List;
import lotto.model.Result;
import lotto.model.User;
import lotto.model.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameController {

    private User user;
    private Result result;

    public GameController() {
        result = new Result();
    }

    public void run() {
        int purchase = InputView.inputPurchase();
        user = new User(purchase);

        OutputView.printLottos(user.getLottoCount(), user.getLottos());

        List<Integer> winningNumber = InputView.inputWinningNumber();
        int bonusNumber = InputView.inputBonusNumber();

        Validator.validateDuplication(winningNumber, bonusNumber);

        result.matchLotto(winningNumber, user.getLottos(), bonusNumber);

        OutputView.printResult(result);
    }
}
