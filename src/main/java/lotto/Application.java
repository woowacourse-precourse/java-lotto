package lotto;

import lotto.controller.Controller;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            Controller controller = new Controller();
            controller.playLotto();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }
}
