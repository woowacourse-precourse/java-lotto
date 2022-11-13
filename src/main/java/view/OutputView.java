package view;

import java.util.List;

public class OutputView {
    public static void showLottos(List <List <Integer>> lottos){
        lottos.forEach(System.out::println);
    }
}
