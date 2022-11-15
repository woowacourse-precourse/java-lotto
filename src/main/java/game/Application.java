package game;

import camp.nextstep.edu.missionutils.Console;
import utills.Invalidator;
import exception.UserInputException;
import outputView.Output;

public class Application {

    public static void main(String[] args) {
        Output.purchasedMsg();

        try {
            int purchaseAmount = Invalidator.isValidPurchaseAmount(Console.readLine());
            int lottoCount = purchaseAmount / 1000;
            Game game = new Game();
            game.play(lottoCount);
        } catch (UserInputException e) {
            System.out.println(e.getMessage());
        }
    }
}
