package lotto;

import lotto.exception.IllegalArgumentError;
import lotto.controller.Controller;

public class Application {


    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            new Controller().start();
        } catch (IllegalArgumentError e) {
            System.out.println(e.getMessage());
        }

    }
}
