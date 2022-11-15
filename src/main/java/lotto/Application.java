package lotto;

import lotto.view.View;

public class Application {
    public static void main(String[] args) {
        View view = new View();
        try {
            view.run();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
