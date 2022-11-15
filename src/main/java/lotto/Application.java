package lotto;

import lotto.UI.View;
import lotto.domain.Game;
import lotto.domain.User;

public class Application {
    public static void main(String[] args) {
        Game game = new Game();
        User user = new User();
        View view = new View();
        Controller controller = new Controller(game, user, view);
        controller.run();
    }
}
