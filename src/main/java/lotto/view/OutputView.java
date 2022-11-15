package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Rank;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class OutputView {

    public static void printLottoTicktesCount(int ticketCount) {
        System.out.printf("%d개를 구매했습니다.\n", ticketCount);
    }

    public static void printLottoTikects(List<Lotto> lottoTickets) {
        for (Lotto lotto : lottoTickets) {
            List<Integer> lottoNumbers = lotto.getNumbers();
            List<Integer> sorted = lottoNumbers.stream()
                    .sorted()
                    .collect(Collectors.toList());
            System.out.println(sorted);
        }
    }

    public static void printWinningStatistics(Map<Rank, Integer> result) {
        System.out.println("당첨 통계\n---");
        DecimalFormat df = new DecimalFormat("###,###");
        List<Rank> sortedRanks = Arrays.stream(Rank.values())
                .sorted(Comparator.reverseOrder())
                .filter(rank -> rank != Rank.NORANK)
                .collect(Collectors.toList());
        for (Rank rank : sortedRanks) {
            String money = df.format(rank.getMoney());
            System.out.printf("%d개 일치%s (%s원) - %d개\n", rank.getCorrectNumCount(), getBonusPrint(rank),money, result.get(rank));
        }
    }
    public static void printRate(double rate){
        System.out.printf("총 수익률은 %.1f%%입니다.",rate);
    }
    private static String getBonusPrint(Rank rank){
        if(rank.equals(Rank.SECOND)){
            return ", 보너스 볼 일치";
        }
        return "";
    }

}
