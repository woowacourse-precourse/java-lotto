package lotto.domain;

import lotto.ui.LottoViewer;
import lotto.utils.InputUtil;

import java.util.List;

public class LottoApplication2 {
    private LottoStore lottoStore = new LottoStore();

    public void run() {
        LottoViewer.showEnterPurchaseAmount();
        int purchaseAmount = InputUtil.purchaseAmount();
        List<Lotto> boughtLottos = lottoStore.buy(purchaseAmount);
        LottoViewer.showLottoNumberList(boughtLottos);
        LottoViewer.showEnterLottoNumber();
        Lotto winLotto = new Lotto(InputUtil.lottoNumber());
        LottoViewer.showEnterLottoBonusNumber();
        int bonusNumber = InputUtil.getBonusNumber();
        LottoGame lottoGame = new LottoGame(winLotto, bonusNumber);
        lottoGame.checkMatchLotto(boughtLottos);
    }
}
