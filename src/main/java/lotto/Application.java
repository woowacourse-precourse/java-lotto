package lotto;

import lotto.UI.View;
import lotto.domain.Game;
import lotto.domain.User;

public class Application {
    public static void main(String[] args) {
        try {
            Game game = new Game();
            User user = new User();
            View view = new View();
            Controller controller = new Controller(game, user, view);
            controller.setBudget();
            controller.buyLotto();
            controller.showLottos();
            controller.setWinningNumbers();
            controller.setBonus();
            controller.computeStatistics();
            controller.showStatistics();
        }
        catch (IllegalArgumentException exception){
            System.out.println("[ERROR]");
        }
    }
}
