package lotto;

import java.util.List;
import java.util.function.IntBinaryOperator;
import lotto.domain.Money;
import lotto.view.InputView;
import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.Lottos;

public class Application {
    public static void main(String[] args) {
        Money money = new Money(InputView.inputPurchaseMoney());
        int lottoCount = money.countLotto();

        Lottos lottos = new Lottos(LottoGenerator.generateLottos(lottoCount));

    }
}
