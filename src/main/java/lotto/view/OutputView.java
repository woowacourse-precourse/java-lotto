package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class OutputView {

    public void printLottos(List<Lotto> lottos) {
        System.out.println();
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers()); //getter 없애기
        }
    }
}
