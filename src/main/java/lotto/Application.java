package lotto;

import lotto.view.InputView;

public class Application {

    public static void main(String[] args) {
        int amount = InputView.askAmount();
        System.out.println(amount);
        AmountValidator.validate(amount);
        Tickets tickets = new Tickets(amount);
    }
}
