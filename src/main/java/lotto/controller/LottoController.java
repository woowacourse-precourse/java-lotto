package lotto.controller;

import lotto.model.MoneyService;
import lotto.model.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private LottoService lottoService;

    public LottoController() {
        createLottos(getMoney());
    }

    private int getMoney() {
        MoneyService money = new MoneyService(InputView.inputMoney());

        return money.getLottoCount();
    }

    private void createLottos(int lottoCount) {
        OutputView.outputAnnounceMoney(lottoCount);
        lottoService = new LottoService(lottoCount);
        OutputView.outputLottoList(lottoService.getLottoList());
    }
}
