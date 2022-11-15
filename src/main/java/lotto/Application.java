package lotto;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        try {
            Money money = new Money(inputView.inputMoney());
            outputView.moneyOutput(money.getLottoAmount());

            LottoFactory lottoFactory = new LottoFactory(money.getLottoAmount());
            outputView.lottoFactoryOutput(money.getLottoAmount(), lottoFactory.getLottos());

            Lotto lotto = new Lotto(inputView.inputLotto());
            BonusLotto bonusLotto = new BonusLotto(inputView.inputBonusLotto());

            LottoResult lottoResult = new LottoResult(money.getMoney(), lottoFactory.getLottos(), lotto.getNumbers(), bonusLotto.getBonusNumber());
            outputView.lottoResult(lottoResult.getLottoCount(), lottoResult.getYield());

        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }




    }
}
