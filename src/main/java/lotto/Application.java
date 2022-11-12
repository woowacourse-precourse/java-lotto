package lotto;

import lotto.domain.Controller;

public class Application {
    public static void main(String[] args) {
        Config.validate();
        Controller gameController = Controller.getInstance();
        gameController.run();
    }
}
