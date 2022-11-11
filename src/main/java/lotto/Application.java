package lotto;

import lotto.view.InputView;

public class Application {

    public static void main(String[] args) {
        Money money = new Money(InputView.askAmount());
        Lottos lottos = new Lottos(money.getMoney());
    }
}
