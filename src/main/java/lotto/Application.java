package lotto;

import lotto.views.Input;

public class Application {
    public static void main(String[] args) {
        GameManager gameManager = new GameManager(new Input());
        try{
            gameManager.run();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
