package lotto.view;

import lotto.domain.IssuedLottos;
import lotto.domain.Lotto;
import lotto.domain.WinningStatistic;

import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class OutputView {
    private OutputView() {

    }

    public static void showIssuedLottos(IssuedLottos issuedLottos) {
        System.out.println(issuedLottos.getIssueCount() + "개를 구매했습니다.");

        for (Lotto lotto : issuedLottos.getIssuedLotto()) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void showStatistic(Map<WinningStatistic.Ranking, Integer> map, IssuedLottos issuedLottos) {
        AtomicLong totalWinnings = new AtomicLong();

        map.forEach((key, value) -> {
            totalWinnings.set(totalWinnings.get() + key.getTotalWinning(value));
        });

        double earningRate = (totalWinnings.get() / (double) (issuedLottos.getIssueCount() * 1000)) * 100;

        System.out.println("당첨 통계");
        System.out.println("___");
        System.out.println("3개 일치 (5,000원) - " + map.getOrDefault(WinningStatistic.Ranking.FIFTH, 0) + "개");
        System.out.println("4개 일치 (50,000원) - " + map.getOrDefault(WinningStatistic.Ranking.FOURTH, 0) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + map.getOrDefault(WinningStatistic.Ranking.THIRD, 0) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + map.getOrDefault(WinningStatistic.Ranking.SECOND, 0) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + map.getOrDefault(WinningStatistic.Ranking.FIRST, 0) + "개");
        System.out.printf("총 수익률은 %.1f%%입니다.", earningRate); // 수익률 = (당첨금액 / 사용금액) * 100
    }
}
