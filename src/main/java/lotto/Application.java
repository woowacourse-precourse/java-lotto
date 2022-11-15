package lotto;

import lotto.domain.LottoCount;
import lotto.util.LottoNumberGenerator;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.result.Result;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        try {
            Money money = new Money(InputView.inputMoney());
            LottoCount lottoCount = new LottoCount(money);
            OutputView.printLottoCount(lottoCount);

            Lottos lottos = new LottoNumberGenerator().generateLottos(lottoCount);
            OutputView.printPurchasedLottoNumbers(lottos);

            String winningLottoNumbers = InputView.inputWinningLottoNumbers();
            Integer bonusNumber = InputView.inputBonusNumber();
            WinningLotto winningLotto = new WinningLotto(winningLottoNumbers, bonusNumber);

            Result result = new Result(lottos, winningLotto);
            OutputView.printStatistic(result);
            OutputView.printYield(result, money);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
