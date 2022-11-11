package lotto.controller;

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
}
