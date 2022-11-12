package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private LottoService lottoService = new LottoService();
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();

    public void run() {
        List<Lotto> lottoBundle = buyLotto();
        List<LottoResult> lottoResults = getLottoResults(lottoBundle);
        printResultMessage(lottoResults);
    }

    private List<Lotto> buyLotto() {
        List<Lotto> lottoBundle =  lottoService.buy(inputView.sendMoney());
        outputView.printLottoBundleInfo(lottoBundle);

        return lottoBundle;
    }

    private List<LottoResult> getLottoResults(List<Lotto> lottoBundle) {
        List<Integer> winningNumbers = inputView.sendWinningNumbers();
        int bonusNumber = inputView.sendBonusNumber(winningNumbers);
        List<LottoResult> lottoResults = lottoService.compareLottoNumbers(lottoBundle, winningNumbers, bonusNumber);

        return lottoResults;
    }

    private void printResultMessage(List<LottoResult> lottoResults) {
        outputView.printLottoResult(lottoResults);
        outputView.printYield(lottoService.calculateYield(lottoResults));
    }
}
