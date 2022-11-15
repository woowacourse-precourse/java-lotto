package lotto;

import lotto.domain.Lotto;
import lotto.domain.Player;
import lotto.domain.Statistic;

import static lotto.view.InputView.*;
import static lotto.view.InputView.showBonusNumberInputMessage;
import static lotto.view.OutputView.*;

public class Game {
    private final Player player;

    public Game() {
        player = new Player();
    }

    public void start() {
        purchaseLotto();

        showWinningNumberInputMessage();
        Lotto winningNumbers = player.getWinningNumbers();

        showBonusNumberInputMessage();
        int bonusNumber = player.getBonusNumber(winningNumbers);

        compareLottoNumbers(winningNumbers, bonusNumber);

        showStatistic();
        showRateOfReturn(player.getRateOfReturn());
    }

    public void purchaseLotto() {
        showPurchaseInputMessage();
        player.getPurchaseCost();
        player.purchaseLotto();
        printPurchasedLotto(player.getLottos());
    }

    public void compareLottoNumbers(Lotto winningNumbers, int bonusNumber) {
        for(Lotto lotto : player.getLottos()) {
            int matchCount = lotto.countMatchingNumbers(winningNumbers);
            boolean matchBonus = lotto.checkBonusNumber(bonusNumber);
            Statistic.setCounts(matchCount, matchBonus);
        }
    }
}
