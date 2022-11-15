package lotto;

import lotto.controller.Controller;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            new Controller().playLotto();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }
}
