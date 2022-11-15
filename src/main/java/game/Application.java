package game;

import camp.nextstep.edu.missionutils.Console;
import utills.Invalidator;
import exception.UserInputException;
import view.Output;

public class Application {

    public static void main(String[] args) {
        Output.purchasedMsg();

        try {
            int purchaseAmount = Invalidator.isValidPurchaseAmount(Console.readLine());
            Game game = new Game(purchaseAmount);
            game.play();
        } catch (UserInputException e) {
            System.out.println(e.getMessage());
        }
    }
}
