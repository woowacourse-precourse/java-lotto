package lotto.domain;

import lotto.ui.LottoViewer;
import lotto.utils.InputUtil;

import java.util.List;

public class LottoApplication {
    private final LottoStore lottoStore = new LottoStore();

    public void run() {
        int purchaseAmount = inputPurchaseAmountProcess();

        List<Lotto> lottoTickets = purchaseLottoTicketsProcess(purchaseAmount);

        Lotto winningLotto = getWinningLottoNumberProcess();
        int bonusNumber = inputBonusNumberProcess(winningLotto);

        LottoGame lottoGame = new LottoGame(winningLotto, bonusNumber, lottoTickets);
        LottoStatistics lottoStatistics = lottoGame.checkMatchLotto();

        LottoViewer.showWinningStatisticsText(lottoStatistics);
    }

    private int inputPurchaseAmountProcess() {
        LottoViewer.showPurchaseAmountInputText();
        return InputUtil.readPurchaseAmount();
    }

    private int inputBonusNumberProcess(Lotto winningLotto) {
        LottoViewer.showBonusLottoNumberInputText();
        return InputUtil.readBonusNumber(winningLotto);
    }

    private Lotto getWinningLottoNumberProcess() {
        LottoViewer.showWinningLottoNumberInputText();
        return new Lotto(InputUtil.readWinningLottoNumber());
    }

    private List<Lotto> purchaseLottoTicketsProcess(int purchaseAmount) {
        List<Lotto> lottoTickets = lottoStore.buy(purchaseAmount);
        LottoViewer.showCountOfLottoTickets(lottoTickets.size());
        LottoViewer.showLottoTickets(lottoTickets);
        return lottoTickets;
    }
}
