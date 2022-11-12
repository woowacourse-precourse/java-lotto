package lotto.view;

import java.util.List;

public class OutputView {
    private static final String BOUGHT_LOTTO_COUNT = "%d개를 구매했습니다.\n";

    private OutputView() {
    }

    public static void printIssuedLotto(List<List<Integer>> lottos) {
        printIssuedLottoCount(lottos.size());
        printLottos(lottos);
    }

    private static void printIssuedLottoCount(int size) {
        System.out.printf(BOUGHT_LOTTO_COUNT + "\n", size);
    }

    private static void printLottos(List<List<Integer>> lottos) {
        for (List<Integer> lotto : lottos) {
            System.out.println(lotto);
        }
    }
}
