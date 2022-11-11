package lotto;

import lotto.InputOutput.UserInputHandler;

public class Application {
    static UserInputHandler inputHandler;

    public static void main(String[] args) {
        Application lottoApplication = new Application();

        inputHandler = new UserInputHandler();
        lottoApplication.start();
    }

    void start(){

        inputHandler.getHowMuchTickets();
    }
}
