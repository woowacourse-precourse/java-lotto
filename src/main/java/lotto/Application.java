package lotto;

import lotto.View.Game;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            // TODO: 프로그램 구현
            new Game().start();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}