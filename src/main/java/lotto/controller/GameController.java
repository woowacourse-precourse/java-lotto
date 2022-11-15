package lotto.controller;

import java.util.List;
import lotto.model.Result;
import lotto.model.User;
import lotto.model.Validator;
import lotto.view.GameView;

public class GameController {

    private GameView gameConsole;
    private User user;
    private Result result = new Result();

    public GameController() {
        gameConsole = new GameView();
    }

    public void run() {
        int purchase = gameConsole.inputPurchase();
        user = new User(purchase);

        gameConsole.printLottos(user.getLottoCount(), user.getLottos());

        List<Integer> winningNumbers = gameConsole.inputWinningNumber();
        int bonusNumber = gameConsole.inputBonusNumber();

        Validator.validateDuplication(winningNumbers, bonusNumber);
        
        result.matchLotto(winningNumbers, user.getLottos(), bonusNumber);
        result.initWinningAmount(purchase);

        gameConsole.printResult(result);
    }
}
