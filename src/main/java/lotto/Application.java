package lotto;

import lotto.controller.AppController;

public class Application {
    public static void main(String[] args) {
        AppController appController = new AppController();
        try {
            appController.run();
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
