package lotto;

import lotto.model.LottoCount;
import lotto.util.LottoNumberGenerator;
import lotto.model.Lottos;
import lotto.model.Money;
import lotto.model.Result;
import lotto.model.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        Money money = new Money(InputView.inputMoney());
        LottoCount lottoCount = new LottoCount(money);
        OutputView.printLottoCount(lottoCount);

        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        Lottos lottos = lottoNumberGenerator.generateLottos(lottoCount);
        OutputView.printPurchasedLottoNumbers(lottos);

        String winningLottoNumbers = InputView.inputWinningLottoNumbers();
        Integer bonusNumber = InputView.inputBonusNumber();
        WinningLotto winningLotto = new WinningLotto(winningLottoNumbers, bonusNumber);

        Result result = new Result(lottos, winningLotto);
        OutputView.printResult(result);
        OutputView.printYield(result, money);
    }
}
