package lotto.view;

import lotto.model.Lottos;

public class OutputView {
    public static void printLottosHistory(Lottos lottos) {
        System.out.println();
        lottos.printAll();
    }
}
