package lotto.view;

import lotto.DataTable.PrizeTable;

import java.text.NumberFormat;
import java.util.Map;

public class ResultView {
    public static void printHeader() {
        System.out.println("당첨 통계\n---");
    }

    public static void printRanks(Map<Integer, Integer> rank, double yield) {
        for (PrizeTable prizeTable : PrizeTable.values()) {
            NumberFormat printMoney = NumberFormat.getInstance();

            if (prizeTable.count == 0) {
                System.out.printf("5개 일치, 보너스 볼 일치 (%s원) - %d개\n", printMoney.format(prizeTable.prize), rank.get(prizeTable.count));
            }
            if (prizeTable.count != 0) {
                System.out.printf("%d개 일치 (%s원) - %d개\n", prizeTable.count, printMoney.format(prizeTable.prize), rank.get(prizeTable.count));
            }
        }
        System.out.printf("총 수익률은 %.1f%%입니다.", yield);
    }
}


