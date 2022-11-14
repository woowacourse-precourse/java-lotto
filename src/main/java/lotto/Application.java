package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {

    public static void main(String[] args) {
        try {
            InputView inputView = new InputView();
            int moneyForLottos = inputView.inputMoneyForLottos();
            LottoSalesMachine lottoSalesMachine = new LottoSalesMachine();
            Lottos lottos = new Lottos(lottoSalesMachine.createLottos(moneyForLottos));
            OutputView outputView = new OutputView();
            outputView.printLottoNumbers(lottos);
            Lotto winningLotto = inputView.inputWinningLottoNumber();
            BonusNumber bonusNumber = inputView.inputBonusLottoNumber(winningLotto);
            LottoResults lottoResults = lottos.compareToLottoNumbers(winningLotto, bonusNumber);
            outputView.printLottoResults(lottoResults);
            outputView.printRatioOfReturn(lottoResults);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
        }
    }
}
