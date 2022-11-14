package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameController game = new GameController();

        game.buyLotto();
        game.drawLotto();
        game.printLotto();
        game.getResult();




    }
}
