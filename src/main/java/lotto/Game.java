package lotto;

import java.util.List;

public class Game {
    private Ui ui;
    private LottoTicket lottoTicket;

    public Game(Ui ui, LottoTicket lottoTicket) {
        this.ui = ui;
        this.lottoTicket = lottoTicket;
    }

    public void start() {
        String purchaseAmount = ui.returnInputValue("구입금액을 입력해 주세요.");
        List<Lotto> lottos = lottoTicket.buy(purchaseAmount);
        ui.printLottos(lottos);

        String winningNumbers = ui.returnInputValue("당첨 번호를 입력해 주세요.");
        String bonusNumber = ui.returnInputValue("보너스 번호를 입력해 주세요.");
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

        WinningResult winningResult = new WinningResult(winningLotto, lottos);
        ui.printWinningStatistics(winningResult);
        ui.printTotalProfit(winningResult, purchaseAmount);
    }
}
