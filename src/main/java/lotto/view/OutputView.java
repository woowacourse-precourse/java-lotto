package lotto.view;

import java.util.List;

public class OutputView {
    private static final String BOUGHT_LOTTO_COUNT = "%d개를 구매했습니다.";

    private OutputView() {
    }

    public static void printIssuedLotto(List<List<Integer>> lottos) {
        printIssuedLottoCount(lottos.size());
        printLottos(lottos);
    }

    private static void printIssuedLottoCount(int size) {
        System.out.printf("\n" + BOUGHT_LOTTO_COUNT + "\n", size);
    }

    private static void printLottos(List<List<Integer>> lottos) {
        lottos.forEach(System.out::println);
    }
}
