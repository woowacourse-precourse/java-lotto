package lotto.domain.lotto.presentation.dto;

import lotto.domain.lotto.service.LottoService;
import lotto.domain.view.OutputView;

public class LottoController {

    LottoService lottoService = new LottoService();

    public int getInputMoney() {
        return lottoService.inputMoney();
    }

    public void getLottoCount(int inputMoney) {
        OutputView.printCountByBuyLotto(lottoService.lottoCount(inputMoney));
    }
}
