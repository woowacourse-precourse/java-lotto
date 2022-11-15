package lotto;

import lotto.controller.MainController;

public class Application {
    public static void main(String[] args) {
        try {
            MainController.run();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
