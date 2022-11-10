package lotto.domain.lotto.presentation;

import lotto.domain.lotto.domain.Lotto;
import lotto.domain.lotto.service.LottoService;
import lotto.domain.view.OutputView;

public class LottoController {

    private final LottoService lottoService = new LottoService();

    public int getLottoCount(int inputMoney) {
        int lottoCount = lottoService.lottoCount(inputMoney);
        OutputView.printCountByBuyLotto(lottoCount);
        return lottoCount;
    }

    public Lotto getLotto() {
        Lotto lotto = lottoService.randomLottoNumbers();
        OutputView.printLottoNumbers(lotto);
        return lotto;
    }

    public Lotto getPrizeLotto() {
        return lottoService.prizeLotto();
    }

    public int getBonusNumber() {
        return lottoService.bonusNumber();
    }
}
