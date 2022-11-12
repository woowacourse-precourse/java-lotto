package lotto;

import lotto.io.View;
import lotto.model.Lotto;

import java.util.List;

public class LottoProgram {
    private final View view;
    private final LottoService lottoService;

    public LottoProgram(View view, LottoService lottoService) {
        this.view = view;
        this.lottoService = lottoService;
    }

    public void run() {
        view.requestPurchaseAmount();
        int purchaseAmount = view.getPurchaseAmount();
        List<Lotto> lotto = lottoService.create(purchaseAmount);
        view.showLotto(lotto);
    }
}

