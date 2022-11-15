package lotto.view;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.lotto.Lotto;
import lotto.domain.Rank;
import lotto.domain.WinningResult;

public class OutputView {

    public static void printBuyHistory(List<Lotto> lottos) {
        // TODO: Parser 로 옮기기
        String start = "[";
        String end = "]";
        String delimiter = ", ";

        int amount = lottos.size();
        System.out.println(String.format("%d개를 구매했습니다.", amount));
        for (Lotto lotto : lottos) {
            String lottoStr = lotto.getNumbers().stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(delimiter));
            System.out.println(start + lottoStr + end);
        }
    }

    public static void printWinningDetails(WinningResult winningResult) {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (Rank rank : Rank.values()) {
            if (rank.equals(Rank.MISS)) {
                continue;
            }
            String result = String.format("%d개 일치 (%,d원) - %d개", rank.getCountOfMatch(), rank.getWinningMoney(),
                    winningResult.getRankCount().get(rank));
            if (rank.equals(Rank.SECOND)) {
                result = String.format("%d개 일치, 보너스 볼 일치 (%,d원) - %d개", rank.getCountOfMatch(), rank.getWinningMoney(),
                        winningResult.getRankCount().get(rank));
            }

            System.out.println(result);
        }
    }

    public static void printProfit(double profit) {
        System.out.println(String.format("총 수익률은 %.1f%%입니다.", profit));
    }

}