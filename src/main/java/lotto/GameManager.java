package lotto;

import lotto.views.Input;

public class GameManager {

    private final Input input;

    public GameManager(Input input) {
        this.input = input;
    }

    public void run() {
        input.getLottoPrice();
    }
}
