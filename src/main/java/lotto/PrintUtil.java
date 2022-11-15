package lotto;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class PrintUtil {

        public static void getLottos(int userLottoCnt) {
            System.out.println(userLottoCnt + "개를 구매했습니다.");
        }

        public static void userLottosPrint(List<Lotto> userLottos) {
            for(Lotto lotto : userLottos){
                System.out.print("[");
                userNumberPrint(lotto);
                System.out.print("]\n");
            }
        }

        private static void userNumberPrint(Lotto lotto) {
            for(int i = 0 ; i < lotto.getNumbers().size() ; i++){
                if(i == lotto.getNumbers().size() - 1){
                    System.out.print(lotto.getNumbers().get(i));
                    return;
                }
                System.out.print(lotto.getNumbers().get(i) + ", ");
            }
        }

    public static void inputWinNumberGuide() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void inputBonusNumberGuide() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void printStatistics(List<Integer> ranks) {
        System.out.println("당첨 통계");
        System.out.println("---");

        int[] rankCount = new int[5];

        for(int rank : ranks){
            if(rank > 5) continue;
            rankCount[rank-1]++;
        }

        printRankCount(rankCount);
    }

    private static void printRankCount(int[] rankCount) {
        for(int i = 0 ; i < rankCount.length ; i++){
            printWinList(rankCount[i], i);
        }
    }

    private static void printWinList(int rank, int idx) {
        if(idx == 0) System.out.println("6개 일치 (2,000,000,000원) - " + rank + "개");
        if(idx == 1) System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + rank + "개");
        if(idx == 2) System.out.println("5개 일치 (1,500,000원) - " + rank + "개");
        if(idx == 3) System.out.println("4개 일치 (50,000원) - " + rank + "개");
        if(idx == 4) System.out.println("3개 일치 (5,000원) - " + rank + "개");
    }

    public static void printRevenue(int revenue, int userLottoCnt) {
        double revenuePercent = (double) revenue / (double) (userLottoCnt * 1000);
        revenuePercent *= 100;
        String str = String.format("%.1f", revenuePercent);
        System.out.println("총 수익률은 " + str + "%입니다.");
    }
}
