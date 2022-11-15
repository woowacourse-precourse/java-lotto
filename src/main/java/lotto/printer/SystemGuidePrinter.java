package lotto.printer;

import lotto.domain.Lotto;

import java.util.List;

public class SystemGuidePrinter {

    public static void purchaseHistoryMessage(List<Lotto> lottoList) {
        int paymentSize = lottoList.size();
        System.out.println(paymentSize + "개를 구매했습니다.");

        for (Lotto lotto: lottoList) {
            System.out.println(lotto.toString());
        }
    }

    public static void winningHistoryMessage(int[] winningResult, double revenue) {
        System.out.println("당첨 통계");
        System.out.println("---");

        System.out.println("3개 일치 (5,000원) - " + winningResult[0] + "개");
        System.out.println("4개 일치 (50,000원) - " + winningResult[1] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + winningResult[2] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + winningResult[3] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + winningResult[4] + "개");

        System.out.printf("총 수익률은 %.1f%%입니다.%n", revenue);
    }

}
