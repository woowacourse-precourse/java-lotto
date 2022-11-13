package lotto.domain;

import lotto.ui.LottoViewer;
import lotto.utils.InputUtil;

import java.util.List;

public class LottoApplication {
    private final LottoStore lottoStore = new LottoStore();

    public void run() {
        LottoViewer.showPurchaseAmountInputText();
        int purchaseAmount = InputUtil.readPurchaseAmount();
        List<Lotto> lottoTickets = lottoStore.buy(purchaseAmount);
        LottoViewer.showCountOfLottoTickets(lottoTickets.size());
        LottoViewer.showLottoTickets(lottoTickets);
        LottoViewer.showWinningLottoNumberInputText();
        Lotto winningLotto = new Lotto(InputUtil.readWinningLottoNumber());
        LottoViewer.showBonusLottoNumberInputText();
        int bonusNumber = InputUtil.readBonusNumber(winningLotto);
        LottoGame lottoGame = new LottoGame(winningLotto, bonusNumber, lottoTickets);
        LottoCount lottoCount = lottoGame.checkMatchLotto();
        LottoViewer.showWinningStatisticsText(lottoCount);
        LottoViewer.showYield(lottoCount.getYield(purchaseAmount));
    }
}
