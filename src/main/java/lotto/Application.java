package lotto;

import lotto.controller.Controller;

public class Application {
    public static void main(String[] args) {
        try {
            Controller controller = new Controller();
        }catch (Exception e) {
            System.out.println("[ERROR] 잘못된 입력 입니다.");
            e.initCause(new IllegalArgumentException());
            System.out.println(e.getCause());
        }
    }
}
