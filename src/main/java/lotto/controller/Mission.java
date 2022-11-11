package lotto.controller;

import lotto.domain.Money;
import lotto.view.Input;
import lotto.view.Output;

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
        Output.printErrorAndExit(errorMessage);
        System.exit(0);
    }
}
