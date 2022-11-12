package lotto;

import lotto.input.NextStepInputReader;

public class Application {
    public static void main(String[] args) {
        try {
            User user = new User(new NextStepInputReader());
            user.askPurchaseAmount();
        } catch (IllegalArgumentException e) {
            Logger.printError(e.getMessage());
        }
    }
}
