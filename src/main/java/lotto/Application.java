package lotto;

import controller.Controller;

public class Application {
    public static void main(String[] args) {
        Controller controller = new Controller();
        try {
            controller.run();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
