package lotto;

import lotto.controller.GameController;

public class Application {
    public static void main(String[] args) {
        try {
            GameController.run();
        } catch(IllegalArgumentException e){
            System.out.println("[ERROR] "+e.getMessage());
        }
    }
}
