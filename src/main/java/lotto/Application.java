package lotto;

import lotto.domain.Money;
import lotto.view.InputView;

public class Application {
    public static void main(String[] args) {
        Money money = new Money(InputView.inputMoney());

    }
}
