package lotto.view;

import lotto.domain.Prize;

import java.util.LinkedHashMap;

public class OutView {
    public static void printNumberOfPurchases(int n) {
        System.out.println(n + "개를 구매했습니다.");
    }

    public static void printWinningStatistics(LinkedHashMap<Prize, Integer> history, String yield) {
        System.out.println("당첨 통계\n---");

        for( Prize key : history.keySet() ){
            if (key != Prize.LOSING_TICKET)
                System.out.println(key.getMatchN() + "개 일치"
                        + key.getStringAmount() + " - " + history.get(key) + "개");
        }

        System.out.println("총 수익률은 " + yield + "%입니다.");
    }
}
