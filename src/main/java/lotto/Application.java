package lotto;

import lotto.controller.ApplicationManager;

public class Application {
    public static void main(String[] args) {
        try {
            ApplicationManager applicationManager = new ApplicationManager();
            applicationManager.run();

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
