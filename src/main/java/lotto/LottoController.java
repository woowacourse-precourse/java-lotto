package lotto;

import java.util.List;

public class LottoController {

    private LottoService lottoService = new LottoService();
    private LottoView lottoView = new LottoView();
    private InputDevice inputDevice = new InputDevice();

    public void run() {
        lottoView.printStartMessage();
        List<Lotto> lottoTickets =  lottoService.buy(inputDevice.sendMoneyToBuyLotto());
        lottoView.printLottoInfo(lottoTickets);
        lottoView.printWinningNumbersSettingMessage();
        List<Integer> winningNumbers = inputDevice.sendWinningNumbers();
        int bonusNumber = inputDevice.sendBonusNumber(winningNumbers);
        List<LottoResult> lottoResults = lottoService.compareLottoNumbers(lottoTickets, winningNumbers, bonusNumber);
        lottoView.printLottoResult(lottoResults);
        double yield = lottoService.calculateYield(lottoResults);
        lottoView.printYield(yield);
    }
}
