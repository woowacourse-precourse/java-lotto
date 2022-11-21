package lotto.game.controller;

import static lotto.game.view.UI.*;

import java.util.List;
import lotto.game.domain.Lotto;
import lotto.game.domain.TotalResult;
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
        List<Lotto> lottos = lottoService.buyLottos(money);
        ui.printPurchasedLottos(lottos);

        String winningNumbers = ui.receiveInput(MESSAGE_WINNING_NUMBER);
        String bonusNumber = ui.receiveInput(MESSAGE_BONUS_NUMBER);
        WinningLotto winningLotto = WinningLotto.of(winningNumbers, bonusNumber);
        List<LottoGrade> lottoGrades = lottoService.confirmAllLottos(winningLotto, lottos);
        TotalResult totalResult = TotalResult.of(lottoGrades);
        ui.printTotalResult(totalResult);

        Money totalProfit = lottoService.calculateTotalProfit(lottoGrades);
        ui.printProfitRate(lottoService.calculateProfitPercent(money, totalProfit));
    }
}
