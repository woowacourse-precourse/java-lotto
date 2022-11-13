package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
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
        /*NumberGenerator ng = new NumberGenerator(3);

        ng.generateNumbers();

        System.out.println(ng.myLotto);*/


//        Lotto lotto = new Lotto(List.of(8, 22, 13, 4, 35, 6));
//        Lotto lotto = new Lotto(List.of(4,6,8,13,22,35));
//        System.out.println(lotto.getNumbers());

        List<Integer> list = new ArrayList<>(List.of(1,2,13,4,5,6));

        Collections.max(list);

        System.out.println(Collections.min(list));


    }
}
