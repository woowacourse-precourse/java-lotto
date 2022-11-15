package lotto.view;

import lotto.domain.Prize;

import java.util.List;

public class OutView {
    public static void numberOfPurchases(int n) {
        System.out.println(n + "개를 구매했습니다.");
    }

    public static void winningStatistics(List<Prize> winStatistics
            , List<Integer> history, float yield) {
        System.out.println("당첨 통계\n---");
        for (int i = 0; i < winStatistics.size(); i++) {
            Prize ws = winStatistics.get(i);
            System.out.println(ws.getMatchN() + "개 일치 "
                    + ws.getStringAmount() + " - " + history.get(i) + "개");
        }

        System.out.println("총 수익률은 " + yield + "%입니다.");
    }
}
