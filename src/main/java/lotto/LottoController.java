package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.Money;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    List<Lotto> userLottos;

    public void runLottoMachine(){
        Money userMoney = Money.from(InputView.inputMoneyByUser());
        userLottos = LottoGenerator.buyMultipleRandomLotto(userMoney);
        OutputView.printUserLottos(userLottos);
    }
}