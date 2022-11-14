package view;

import lotto.LottoRank;
import java.util.List;

public class OutputView {
    public static void printLotteries(List<List<Integer>> totalLotteries) {
        for (int i = 0; i < totalLotteries.size(); i++) {
            List<Integer> lotto = totalLotteries.get(i);
            System.out.println(lotto);
        }
        System.out.println();
    }

    public static void printLottoCount(int lottoCount) {
        System.out.println();
        System.out.printf("%d개를 구매했습니다.\n", lottoCount);
    }

    public static void printResult(int[] rankCount) {
        int i = 3;
        for (LottoRank lottoRank : LottoRank.values()) {
            if (i == 6) { //5개
                i = 7;
            }
            int count = rankCount[i];
            System.out.println(lottoRank.getValue() + " - " + count);
            if (i == 7) {
                i--;
                continue;
            }
            i++;
        }
    }
}
