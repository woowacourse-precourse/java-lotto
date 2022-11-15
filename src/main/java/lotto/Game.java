package lotto;

import lotto.domain.Lotto;
import lotto.domain.Player;

import static lotto.view.InputView.*;
import static lotto.view.OutputView.*;

public class Game {
    private final Player player;

    public Game() {
        player = new Player();
    }

    public void start() {
        showPurchaseInputMessage();
        player.getPurchaseCost();
        player.purchaseLotto();
        printPurchasedLotto(player.getLottos());

        showWinningNumberInputMessage();
        Lotto winningNumbers = player.getWinningNumbers();
    }
}
