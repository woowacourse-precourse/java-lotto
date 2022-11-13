package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Rank;
import lotto.domain.Result;

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

    public static void printResult(Result result) {
        System.out.println("당첨 통계\n---");
        System.out.printf("3개 일치 (5,000원) - %d개\n", result.getRankCount(Rank.FIFTH));
        System.out.printf("4개 일치 (50,000원) - %d개\n", result.getRankCount(Rank.FOURTH));
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", result.getRankCount(Rank.THIRD));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n",
            result.getRankCount(Rank.SECOND));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", result.getRankCount(Rank.FIRST));
    }

}
