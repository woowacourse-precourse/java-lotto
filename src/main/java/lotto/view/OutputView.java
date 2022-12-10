package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Result;
import lotto.enums.Rank;

import java.util.List;

public class OutputView {
    public static void printLottoCount(int lottoCount) {
        System.out.printf("\n%d개를 구매했습니다.\n", lottoCount / 1000);
    }

    public static void printLotto(List<Lotto> lottoList) {
        for (Lotto lotto : lottoList) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printResult(Result result) {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        System.out.printf("3개 일치 (5,000원) - %d개\n" +
                "4개 일치 (50,000원) - %d개\n" +
                "5개 일치 (1,500,000원) - %d개\n" +
                "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n" +
                "6개 일치 (2,000,000,000원) - %d개", result.getCountMatch().get(Rank.FIFTH)
                , result.getCountMatch().get(Rank.FOURTH)
                , result.getCountMatch().get(Rank.THIRD)
                , result.getCountMatch().get(Rank.SECOND)
                , result.getCountMatch().get(Rank.FIRST));
        System.out.printf("\n총 수익률은 %.1f%%입니다.", result.getTotalPrize());
    }
}
