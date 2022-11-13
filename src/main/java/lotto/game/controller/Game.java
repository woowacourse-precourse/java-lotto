package lotto.game.controller;

import static lotto.game.view.UI.*;

import java.util.List;
import java.util.Map;
import lotto.game.domain.Lotto;
import lotto.game.domain.WinningLotto;
import lotto.game.domain.LottoGrade;
import lotto.game.service.LottoService;
import lotto.game.domain.Money;
import lotto.game.view.UI;

public class Game {
    private final LottoService lottoService;
    private final UI ui;

    private Game(LottoService lottoService, UI ui) {
        this.lottoService = lottoService;
        this.ui = ui;
    }

    public static Game create(LottoService lottoService, UI ui) {
        return new Game(lottoService, ui);
    }

    public void start() {
        Money money = Money.of(ui.receiveInput(MESSAGE_PURCHASE_MONEY));
        List<Lotto> lottos = lottoService.buyLotto(money);
        ui.printPurchasedLottos(lottos);

        String winningNumbersInput = ui.receiveInput(MESSAGE_WINNING_NUMBER);
        String bonusNumberInput = ui.receiveInput(MESSAGE_BONUS_NUMBER);
        WinningLotto winningLotto = WinningLotto.of(winningNumbersInput, bonusNumberInput);

        List<LottoGrade> lottoGrades = lottoService.confirmAllLottos(winningLotto, lottos);
        Map<LottoGrade, Integer> totalWinning = lottoService.getTotalWinning(lottoGrades);

        ui.printTotalResult(totalWinning);
        ui.printProfitRate(lottoService.calculateProfitPercent(money, lottoGrades));
    }
}
