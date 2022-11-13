package lotto;

import java.util.List;
import lotto.domain.Rank;
import lotto.domain.Result;
import lotto.domain.User;
import lotto.domain.Validator;

public class Game {

    private GameConsole gameConsole;
    private User user;

    public Game() {
        gameConsole = new GameConsole();
    }

    public void start() {
        int purchase = gameConsole.inputPurchase();
        user = new User(purchase);

        gameConsole.outputLottos(user.getLottoCount(), user.getLottos());

        List<Integer> winningNumbers = gameConsole.inputWinningNumber();
        int bonusNumber = gameConsole.inputBonusNumber();
        Validator.checkDuplicate(winningNumbers, bonusNumber);

        List<Lotto> lottos = user.getLottos();
        Result result = new Result();
        for (Lotto lotto : lottos) {
            int matchCount = (int)lotto.getNumbers()
                    .stream()
                    .filter(winningNumbers::contains)
                    .count();

            boolean isContainBonusNumber = lotto.getNumbers().contains(bonusNumber);

            result.updateRankInfo(Rank.valueOfRank(matchCount, isContainBonusNumber));
        }

        result.initWinningAmount(purchase);
        gameConsole.outputGameResult(result);
        gameConsole.outputWinningAmount(result);
    }
}
