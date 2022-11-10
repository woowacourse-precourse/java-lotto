package lotto;

import lotto.domain.Money;
import lotto.view.InputView;

public class LottoApplication {

    public static void run() {
        Money money = new Money(InputView.inputPurchaseAmount());
    }
}
