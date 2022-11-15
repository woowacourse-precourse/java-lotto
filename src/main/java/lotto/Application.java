package lotto;

import OutputView.PrintMsg;
import camp.nextstep.edu.missionutils.Console;

import static Exception.Invalidator.*;

public class Application {
    public static void main(String[] args) {

        PrintMsg.purchasedMsg();
        String purchaseAmount = Console.readLine();
        Game game = new Game();
        game.play(isValidPurchaseAmount(purchaseAmount) / 1000);
    }
}
