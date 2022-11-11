package lotto.view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.enums.LottoRank;

public class LottoOutput {

    private static final String BUY_LOTTO = "개를 구매하였습니다.";
    private static final String RANK_LOTTO = "당첨 통계\n---";

    public static void printBuyLotto(int money) {
        int lottoCount = money / 1000;
        System.out.println(lottoCount + BUY_LOTTO);
    }

    public static void printLottoNumbers(ArrayList<List<Integer>> lotteries) {
        for (List<Integer> lotto : lotteries) {
            System.out.println(lotto);
        }
    }

    public static void printLottoRank(List<LottoRank> rankCount) {
        System.out.println(RANK_LOTTO);

        for (LottoRank rank : LottoRank.values()) {
            int count = Collections.frequency(rankCount, rank);

            System.out.printf(LottoRank.getRank(rank) + " (%d원) - %d개\n" ,LottoRank.getPrice(rank), count);
        }
    }

    public static void printLottoProfit(String lottoProfit) {
        System.out.printf("총 수익률은 %s입니다.\n", lottoProfit);
    }
}
