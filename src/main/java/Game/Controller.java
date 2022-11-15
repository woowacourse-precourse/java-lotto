package Game;

import static Exception.Invalidator.*;

public class Controller {

    public static void run(String purchaseAmount) {
        Game game = new Game();
        game.play(isValidPurchaseAmount(purchaseAmount) / 1000);
    }
}
