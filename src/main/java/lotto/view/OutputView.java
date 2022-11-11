package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class OutputView {

    public static void printLottos(Lottos lottos, int lottoCnt) {
        System.out.printf(lottoCnt + "개를 구매했습니다.\n");
        for (Lotto lotto : lottos.get()) {
            printLotto(lotto);
        }
    }

    private static void printLotto(Lotto lotto) {
        StringBuilder sb = new StringBuilder("[");
        for (int number : lotto.get()) {
            sb.append(number + ", ");
        }
        sb.delete(sb.length() - 2, sb.length()).append("]");
        System.out.println(sb);
    }
}
