package lotto;


import game.PlayGame;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            new PlayGame().buyLotto();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
