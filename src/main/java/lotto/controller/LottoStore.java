package lotto.controller;

import lotto.domain.Lotto;
import lotto.ui.InputUi;
import lotto.ui.OutputUi;

import java.util.List;

public class LottoStore {

    private LottoController lottoController;

    public LottoStore() {
        this.lottoController = new LottoController();
    }

    public void startLottoService() {
        List<Lotto> myLottos = buyLottos();
    }

    private List<Lotto> buyLottos() {
        OutputUi.printInsertMoneyInfoMessage();
        int purchasedAmount = InputUi.readPurchaseAmount();

        List<Lotto> generatedLottos = lottoController.generateLottoAuto(purchasedAmount);
        OutputUi.printPurchasedLottos(generatedLottos);

        return generatedLottos;
    }

}
