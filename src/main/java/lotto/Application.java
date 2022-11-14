package lotto;

import java.util.Comparator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Controller controller = new Controller();
        try {
            controller.start();
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
