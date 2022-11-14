package lotto;

import java.util.List;
import lotto.domain.Result;
import lotto.domain.User;
import lotto.domain.Validator;

public class Game {

    private GameConsole gameConsole;
    private User user;
    private Result result = new Result();

    public Game() {
        gameConsole = new GameConsole();
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
