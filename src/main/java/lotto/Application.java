package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Game game = new Game();

        game.buyLotto();
        game.drawLotto();
        game.getResult();
        System.out.println(game.myCorrectNumberResult);
        System.out.println(game.winningLottoNumbers);
        System.out.println(game.myLottoNumbers);

        /*NumberGenerator ng = new NumberGenerator(3);

        ng.generateNumbers();

        System.out.println(ng.myLotto);*/


//        Lotto lotto = new Lotto(List.of(8, 22, 13, 4, 35, 6));
//        Lotto lotto = new Lotto(List.of(4,6,8,13,22,35));
//        System.out.println(lotto.getNumbers());

        /*List<Integer> list = new ArrayList<>(List.of(1,2,13,4,5,6));

        Collections.max(list);

        System.out.println(Collections.min(list));*/
//        List<Integer> list = new ArrayList<>(Arrays.asList(
//                Arrays.asList(1,2,4,7,8,9),Arrays.asList(2,7,13,18,19,33));

        /*List<Integer> list_compare = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> list_origin = new ArrayList<>(List.of(1, 3, 5, 7, 9, 11));
        List<Integer> list_copy = new ArrayList<>();
        list_copy.addAll(list_origin);
//        List<Integer> list_copy = list_origin;

        System.out.println(list_copy);
        System.out.println(list_origin);

        list_copy.retainAll(list_compare);
        System.out.println(list_copy);
        System.out.println(list_origin);*/


    }
}
