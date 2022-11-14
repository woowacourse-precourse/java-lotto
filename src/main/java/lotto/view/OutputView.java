package lotto.view;

import lotto.Lottos;

public class OutputView {
    public static void printLottoCount(Lottos lottos) {
        System.out.println(lottos.getLottos().size() + "개를 구매했습니다.");
    }

    public static void printLottos(Lottos lottos) {
        for (int i = 0; i < lottos.getLottos().size(); i++) {
            System.out.println(lottos.getLottos().get(i).toString());
        }
    }
}
