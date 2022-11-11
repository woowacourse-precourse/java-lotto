package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
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

        WinningLotto winningLotto = makeWinningLotto();
    }

    private List<Lotto> buyLottos() {
        OutputUi.printInsertMoneyInfoMessage();
        int purchasedAmount = InputUi.readPurchaseAmount();
        int lottoNumber = purchasedAmount / Lotto.PRICE;

        List<Lotto> generatedLottos = lottoController.generateLottoAuto(lottoNumber);
        OutputUi.printPurchasedLottos(generatedLottos);

        return generatedLottos;
    }

    private WinningLotto makeWinningLotto() {
        OutputUi.printInputWinningNumbersInfoMessage();

        List<Integer> winningNumbers = InputUi.readWinningLottoNumbers();
        int bonusNumber = InputUi.readSingleNumber();

        return new WinningLotto(winningNumbers, bonusNumber);
    }

}
