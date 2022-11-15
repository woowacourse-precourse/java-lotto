package lotto.Controller;

import lotto.Model.Lotto;
import lotto.Model.WinningLotto;
import lotto.Service.LottoService;
import lotto.View.InputView;
import lotto.View.OutputView;

import java.util.List;
import java.util.Map;

public class WinningNumberController {
    private static LottoService lottoService = new LottoService();
    private static LottoController lottoController = new LottoController();
    private static WinningLotto winningLotto;
    private static Map<Integer, Integer> resultMap;

    public void start() {
        input();
        compareLottoNumbers();
        result();
    }

    private void input() {
        InputView inputView = new InputView();

        String numbers = inputView.readWinningNumber();
        int bonusNumber = inputView.readBonusNumber();

        winningLotto = lottoService.createWinningLotto(numbers, bonusNumber);
    }

    private void compareLottoNumbers() {
        List<Lotto> totalLotto = lottoController.getTotalLottoInstance();

        resultMap = lottoService.compareLottoNumbers(totalLotto, winningLotto);
    }

    private void result() {
        OutputView outputView = new OutputView();

        outputView.printWinningResult(resultMap);

        final int money = lottoController.getMoney();
        double rate = lottoService.getEarningRate(resultMap, money);

        outputView.printEarningRate(rate);
    }
}
