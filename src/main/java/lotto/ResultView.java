package lotto;

import java.util.List;

public class ResultView {

    public void printRandomLottos(List<List<Integer>> lottos) {
        for (List<Integer> lotto : lottos) {
            System.out.println(lotto);
        }
    }
}
