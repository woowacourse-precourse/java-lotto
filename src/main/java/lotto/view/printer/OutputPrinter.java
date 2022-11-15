package lotto.view.printer;

import lotto.domain.Lotto;
import lotto.domain.Rank;

import java.text.NumberFormat;

public class OutputPrinter {
    public static void printBuyInformMessage(int numberOfLotto) {
        System.out.printf("\n%d개를 구매했습니다.%n", numberOfLotto);
    }

    public static void printLottoNumbers(Lotto lotto) {
        System.out.println("[" + lotto.toString() + "]");
    }

    public static void printWinningStatisticsHeader() {
        System.out.println("\n당첨 통계");
        System.out.println("---");
    }

    public static void printWinningPrize(Rank rank, int countOfPrize) {
        NumberFormat numberFormat = NumberFormat.getInstance();
        String prizeMoney = numberFormat.format(rank.getPrizeMoney());
        if(rank == Rank.SECOND){
            System.out.printf("%d개 일치, 보너스 볼 일치 (%s원) - %d개%n", rank.getMatchedCount(), prizeMoney, countOfPrize);
        }
        System.out.printf("%d개 일치 (%s원) - %d개%n", rank.getMatchedCount(), prizeMoney, countOfPrize);
    }

    public static void printWinningProfitRate(String profitRate) {
        System.out.println(String.format("총 수익률은 %s%%입니다.", profitRate));
    }
}
