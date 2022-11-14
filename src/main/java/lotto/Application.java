package lotto;

import lotto.controller.ApplicationController;

public class Application {
    public static void main(String[] args) {
        try {
            ApplicationController applicationController = new ApplicationController();
            applicationController.startApplication();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
