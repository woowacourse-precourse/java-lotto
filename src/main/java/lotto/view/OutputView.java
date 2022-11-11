package lotto.view;

import lotto.Lottos;

public class OutputView {

    public static void printLottos(Lottos lottos) {
        System.out.printf("%d개를 구매했습니다.\n", lottos.getSize());
        System.out.println(lottos);
    }

}
