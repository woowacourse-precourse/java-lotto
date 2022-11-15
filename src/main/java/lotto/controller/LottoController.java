package lotto.controller;

import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.WinningLotto;
import lotto.domain.WinningResult;
import lotto.service.LottoService;
import lotto.util.LottoParser;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final LottoService lottoService;

    public LottoController() {
        this.lottoService = new LottoService();
    }

    public void run() {
        List<Lotto> lottos = buyLottos();
        WinningLotto winningLotto = makeWinningNumbers();
        WinningResult winningResult = lottoService.makeWinningResult(winningLotto, lottos);
        OutputView.printWinningDetails(winningResult);
        OutputView.printProfit(winningResult.getProfit());
    }

    private List<Lotto> buyLottos() {
        String inputMoney = InputView.inputMoney();
        int money = LottoParser.parseToMoney(inputMoney);

        List<Lotto> lottos = lottoService.buyLottos(money);

        OutputView.printBuyHistory(lottos);
        return lottos;
    }

    private WinningLotto makeWinningNumbers() {
        String inputWinningNumbers = InputView.inputWinningNumbers();
        List<Integer> winningNumbers = LottoParser.parseToIntegers(inputWinningNumbers);

        String inputBonusNumber = InputView.inputBonusNumber();
        int bonusNumber = LottoParser.parseToBonumNumber(inputBonusNumber);

        return new WinningLotto(winningNumbers, bonusNumber);
    }
}
