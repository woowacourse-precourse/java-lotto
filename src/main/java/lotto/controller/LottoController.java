package lotto.controller;

import java.util.List;
import lotto.domain.InputDevice;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.service.LottoService;
import lotto.view.LottoView;

public class LottoController {

    private LottoService lottoService = new LottoService();
    private LottoView lottoView = new LottoView();
    private InputDevice inputDevice = new InputDevice();

    public void run() {
        start();
        List<Lotto> lottoTickets = buyLotto();
        List<Integer> winningNumbers = getWinningNumbers();
        int bonusNumber = getBonusNumber(winningNumbers);
        List<LottoResult> lottoResults = getLottoResult(lottoTickets, winningNumbers, bonusNumber);
        printYield(lottoResults);
    }

    private void start() {
        lottoView.printStartMessage();
    }

    private List<Lotto> buyLotto() {
        List<Lotto> lottoBundle =  lottoService.buy(inputDevice.sendMoney());
        lottoView.printLottoBundleInfo(lottoBundle);
        return lottoBundle;
    }

    private List<Integer> getWinningNumbers() {
        lottoView.printWinningNumbersSettingMessage();
        return inputDevice.sendWinningNumbers();
    }

    private int getBonusNumber(List<Integer> winningNumbers) {
        lottoView.printBonusNumberSettingMessage();
        return inputDevice.sendBonusNumber(winningNumbers);
    }

    private List<LottoResult> getLottoResult(List<Lotto> lottoTickets, List<Integer> winningNumbers, int bonusNumber) {
        List<LottoResult> lottoResults = lottoService.compareLottoNumbers(lottoTickets, winningNumbers, bonusNumber);
        lottoView.printLottoResult(lottoResults);
        return lottoResults;
    }

    private void printYield(List<LottoResult> lottoResults) {
        double yield = lottoService.calculateYield(lottoResults);
        lottoView.printYield(yield);
    }
}
