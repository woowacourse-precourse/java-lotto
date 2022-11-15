package lotto.view.printer;

import lotto.domain.Lotto;

import java.text.NumberFormat;

public class OutputPrinter {
    public static void printBuyInformMessage(int numberOfLotto) {
        System.out.printf("%d개를 구매했습니다.%n", numberOfLotto);
    }

    public static void printLottoNumbers(Lotto lotto){
        System.out.println("["+lotto.toString()+"]");
    }

    public static void printWinningStatisticsHeader() {
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    public static void printWinningPrize(int matchedCount, int prizeMoney, int countOfPrize) {
        NumberFormat numberFormat = NumberFormat.getInstance();
        System.out.printf("%d개 일치 (%s원) - %d개%n", matchedCount, numberFormat.format(prizeMoney), countOfPrize);
    }

    public static void printWinningProfitRate(String profitRate) {
        System.out.printf("총 수익률은 %s입니다.%n", profitRate);
    }
}
