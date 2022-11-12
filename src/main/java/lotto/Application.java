package lotto;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Game game = new Game();

        game.buyLotto();
        game.drawLotto();
        game.func();
        System.out.println(game.compareResult);
    }
}
