package lotto.game.controller;

import static lotto.game.view.UI.*;

import java.util.List;
import java.util.Map;
import lotto.game.domain.Lotto;
import lotto.game.domain.WinningLotto;
import lotto.game.domain.LottoGrade;
import lotto.game.service.LottoService;
import lotto.game.domain.Money;

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
