package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        /*Game game = new Game();

        game.buyLotto();
        game.drawLotto();
        game.func();
        System.out.println(game.compareResult);

        System.out.println(game.myLottoNumbers);*/
        NumberGenerator ng = new NumberGenerator(3);

        ng.generateNumbers();

        System.out.println(ng.myLotto);

    }
}
