package lotto;

import lotto.controller.Controller;

public class Application {
    public static void main(String[] args) {
        Controller controller = new Controller();
        try {
            controller.run();
        } catch (Exception e) {
            System.out.println("[ERROR] 프로그램을 종료합니다.");
        }
    }
}
