package lotto;

import lotto.utils.InputValidation;
import lotto.views.Input;

public class Application {
    public static void main(String[] args) {

        GameManager gameManager = new GameManager(new Input());

        gameManager.run();
    }
}
