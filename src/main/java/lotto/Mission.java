package lotto;

import lotto.domain.Money;
import lotto.view.Input;

public class Mission {

    Input input;

    Mission() {
        input = new Input();

        play();
    }

    private void play() {
        Money money = input.getMoney();

    }

    public static void endWithErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
        System.exit(0);
    }
}
