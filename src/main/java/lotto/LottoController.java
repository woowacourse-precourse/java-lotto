package lotto;

import java.util.List;

import lotto.util.LottoParser;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final LottoService lottoService;

    public LottoController() {
        this.lottoService = new LottoService();
    }

    public void run() {
        buyLottos();
        setWinningNumbers();
        result();
    }

    private void buyLottos() {
        String inputMoney = InputView.inputMoney();
        int money = LottoParser.parseToMoney(inputMoney);

        List<Lotto> lottos = lottoService.buyLottos(money);
        OutputView.printBuyHistory(lottos);
    }

    private void setWinningNumbers() {

        String inputWinningNumbers = InputView.inputWinningNumbers();
        List<Integer> winningNumbers = LottoParser.parseToIntegers(inputWinningNumbers);

        String inputBonusNumber = InputView.inputBonusNumber();
        int bonusNumber = LottoParser.parseToBonumNumber(inputBonusNumber);
    }

    private void result() {

    }

}
