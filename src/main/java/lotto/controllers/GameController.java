package lotto.controllers;

import lotto.applications.GameService;
import lotto.domains.Lotto;
import lotto.domains.Place;
import lotto.view.Input;
import lotto.view.Output;

import java.util.List;
import java.util.Map;

public class GameController {
    private static GameController INSTANCE;
    private final GameService gameService;
    private GameController(GameService gameService) {
        this.gameService = gameService;
    }

    public static GameController getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new GameController(GameService.getInstance());
        }
        return INSTANCE;
    }

    public void startGame() {
        final int money = Input.inputPurchaseLottoValue();
        final int numberOfLotto = gameService.getNumberOfLotto(money);
        opening(numberOfLotto);

        final List<Lotto> userBoughtLotteries = gameService.createLotteries(numberOfLotto);
        buyLotto(userBoughtLotteries);

        final List<Integer> winningNumbers = Input.inputWinningNumber();
        final int bonusNumber = Input.inputBonusNumber();

        final Lotto winningLotto = new Lotto(winningNumbers, bonusNumber);
        closing(money, userBoughtLotteries, winningLotto);
    }

    private void opening(int numberOfLotto) {
        Output.printNumberOfPurChase(numberOfLotto);
    }

    private void buyLotto(List<Lotto> lotteries) {
        Output.printUserLottoNumbers(lotteries);
    }

    private void closing(final int money, final List<Lotto> lotteries, final Lotto winningLotto) {
        Map<Place, Integer> prizeMap = gameService.getProfitResult(lotteries, winningLotto);

    }
}
