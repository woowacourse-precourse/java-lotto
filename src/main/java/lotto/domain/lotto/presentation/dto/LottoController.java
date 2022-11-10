package lotto.domain.lotto.presentation.dto;

import lotto.domain.lotto.service.LottoService;
import lotto.domain.view.OutputView;

public class LottoController {

    LottoService lottoService = new LottoService();

    public int getInputMoney() {
        return lottoService.inputMoney();
    }

    public int getLottoCount(int inputMoney) {
        int lottoCount = lottoService.lottoCount(inputMoney);
        OutputView.printCountByBuyLotto(lottoCount);
        return lottoCount;
    }

    public void getLottoNumbers() {
        OutputView.printLottoNumbers(lottoService.randomLottoNumbers());
    }
}
