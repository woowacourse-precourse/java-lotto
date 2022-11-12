package lotto.view;

import lotto.domain.Lotties;
import lotto.domain.Lotto;

public class OutputView {

    public static void printLottoList(Lotties lotties) {
        System.out.println(lotties.getLottiesSize());

        for (Lotto lotto : lotties.getLotties()) {
            System.out.println(lotto);
        }
    }
}
