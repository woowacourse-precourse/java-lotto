package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoTicketResult;
import lotto.domain.WinningHistory;
import lotto.domain.WinningLotto;
import lotto.view.OutputConsole;

import java.util.ArrayList;
import java.util.List;

public class ConfirmationWinningService {
    private final OutputConsole outputConsole;

    public ConfirmationWinningService() {
        this.outputConsole = new OutputConsole();
    }

    public void confirm(List<Lotto> lottos, WinningLotto winningLotto) {
        ArrayList<LottoTicketResult> results = winningLotto.confirmWinning(lottos);
        WinningHistory winningHistory = new WinningHistory(results);
        outputConsole.showWinningStatistics(winningHistory);
    }
}
