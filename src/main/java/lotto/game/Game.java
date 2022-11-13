package lotto.game;

import static lotto.game.UI.*;

import java.util.List;
import java.util.Map;
import lotto.Lotto;
import lotto.WinningLotto;

public class Game {
    private final LottoService lottoService;

    private Game(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public static Game create(LottoService lottoService) {
        return new Game(lottoService);
    }

    public void start() {
        Money money = Money.of(receiveInput(MESSAGE_PURCHASE_MONEY));
        List<Lotto> lottos = lottoService.buyLotto(money);
        printPurchasedLottos(lottos);

        String winningNumbersInput = receiveInput(MESSAGE_WINNING_NUMBER);
        String bonusNumberInput = receiveInput(MESSAGE_BONUS_NUMBER);
        WinningLotto winningLotto = WinningLotto.of(winningNumbersInput, bonusNumberInput);

        List<LottoGrade> lottoGrades = lottoService.confirmAllLottos(winningLotto, lottos);
        Map<LottoGrade, Integer> totalWinning = lottoService.getTotalWinning(lottoGrades);

        printTotalResult(totalWinning);
        printProfitRate(lottoService.calculateProfitPercent(money, lottoGrades));
    }
}
