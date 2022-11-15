package lotto;

import lotto.controller.GameController;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController();
        try {
            gameController.play();

        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
