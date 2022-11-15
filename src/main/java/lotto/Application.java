package lotto;

import lotto.controller.SystemController;

public class Application {
    public static void main(String[] args) {
        SystemController systemController = new SystemController();
        systemController.startLotto();
    }
}