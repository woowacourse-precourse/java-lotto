package lotto;

import java.util.stream.Collectors;

public class ResultView {
    public static void exit(Throwable error) {
        String errMessage = "[ERROR] " + error.getMessage();
        System.out.println(errMessage);
        throw new IllegalArgumentException(errMessage);
    }

    public static void printLottos(Lottos lottos) {
        System.out.println(lottos.getLottoCount() + "개를 구매했습니다.");
        for (Lotto lotto : lottos.getLottos()) {
            printLotto(lotto);
        }
    }

    public static void printLotto(Lotto lotto) {
        System.out.println(lotto.getNumbers().stream().sorted().collect(Collectors.toList()));
    }

    public static void printYield(int yield) {
        System.out.println("총 수익률은 " + String.format("%.1f", yield) + "%입니다.");
    }
}
