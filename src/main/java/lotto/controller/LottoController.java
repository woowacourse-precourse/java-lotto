package lotto.controller;

import lotto.model.GetMoneyService;
import lotto.model.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private LottoService lottoService;

    public LottoController() {
        createLottos(getMoney());
    }

    private int getMoney() {
        GetMoneyService money = new GetMoneyService(InputView.inputMoney());

        return money.getLottoCount();
    }

    private void createLottos(int lottoCount) {
        OutputView.outputAnnounceMoney(lottoCount);
        lottoService = new LottoService(lottoCount);
        OutputView.outputLottoList(lottoService.getLottoList());
    }
}
