package lotto.controller;

import lotto.domain.Lotto;
import lotto.util.ProfitCalculator;
import lotto.domain.WinningLotto;
import lotto.domain.WinningRank;
import lotto.ui.InputUi;
import lotto.ui.OutputUi;

import java.util.List;
import java.util.Map;

public class LottoStore {

    private LottoController lottoController;
    private int purchasedAmount;

    public LottoStore() {
        this.lottoController = new LottoController();
        purchasedAmount = 0;
    }

    public void startLottoService() {

        try {
            List<Lotto> customerLottos = buyLottos();
            WinningLotto winningLotto = makeWinningLotto();
            showWinningStatistic(winningLotto, customerLottos);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }

    }

    private List<Lotto> buyLottos() {
        OutputUi.printInsertMoneyInfoMessage();
        purchasedAmount = InputUi.readPurchaseAmount();
        int lottoNumber = purchasedAmount / Lotto.PRICE;

        List<Lotto> generatedLottos = lottoController.generateLottoAuto(lottoNumber);
        OutputUi.printPurchasedLottos(generatedLottos);

        return generatedLottos;
    }

    private WinningLotto makeWinningLotto() {

        OutputUi.printInputWinningNumbersInfoMessage();
        List<Integer> winningNumbers = InputUi.readWinningLottoNumbers();

        OutputUi.printInputBonusNumberInfoMessage();
        int bonusNumber = InputUi.readSingleNumber();

        return new WinningLotto(winningNumbers, bonusNumber);
    }

    private void showWinningStatistic(WinningLotto winningLotto, List<Lotto> lottos) {
        Map<WinningRank, Integer> winLottoCount = lottoController.countWinLotto(winningLotto, lottos);
        OutputUi.printWinLottoStatistic(winLottoCount);

        int totalProfit = ProfitCalculator.calculateTotalProfit(winLottoCount);
        double profitRate = ProfitCalculator.calculateProfitRate(totalProfit, purchasedAmount);

        OutputUi.printProfitRateMessage(profitRate);
    }

}
