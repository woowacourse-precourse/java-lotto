package lotto;

import java.text.DecimalFormat;

public class PrintStatistics {

    PrintStatistics(int myLottoCnt, int[] totalWin, int totalPrize) {
        System.out.println("당첨 통계");
        System.out.println("---");
        printResult(totalWin);
        Yield yield = new Yield(myLottoCnt, totalPrize);
        printYield(yield.yield);
    }

    private void printResult(int[] totalWin) {
        for (int i = totalWin.length - 1; i >= 0; i--) {
            DecimalFormat df = new DecimalFormat("###,###");
            Win tmp = Win.values()[i];
            System.out.print(tmp.sameNumberCnt() + "개 일치");
            if (i == 1) {
                System.out.print(", 보너스 볼 일치");
            }
            System.out.print(" (" + df.format(tmp.prize()) + "원) ");
            System.out.println("- " + totalWin[i] + "개");
        }
    }

    private void printYield(double yield) {
        System.out.println("총 수익률은 " + yield +"%입니다.");
    }
}
