package lotto;

import view.GameView;

public class Application {
    public static void main(String[] args) {
        GameView gameView = new GameView();

        try {
            gameView.start();
        } catch (Exception e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }
}
