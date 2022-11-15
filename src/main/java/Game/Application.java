package Game;

import OutputView.Output;
import camp.nextstep.edu.missionutils.Console;

import static Exception.Invalidator.isValidPurchaseAmount;

public class Application {

    public static void main(String[] args) {
        Output.purchasedMsg();

        Game game = new Game();
        game.play(isValidPurchaseAmount(Console.readLine()) / 1000);
    }
}
