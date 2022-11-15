package lotto.view;

import lotto.Rank.Rank;
import lotto.strings.Strings;

import java.text.DecimalFormat;

public class StatisticsView {
    public void statisticsView() {

    }
    public void printResult(Rank[] values, double yield) {
        try {
            System.out.println(Strings.statisticsMessage);
            System.out.println(Strings.statisticsMessageLine);
            printInformOfRank(values);
            System.out.println("총 수익률은 " + yield + "%입니다.");
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }
    public void printInformOfRank(Rank[] values) {
        DecimalFormat df = new DecimalFormat("###,###");
        for (int i = 0; i < values.length; i++) {
            if (i == 3) {
                System.out.println(values[i].getRank() + "개 일치, 보너스 볼 일치 "
                        + "(" + df.format(values[i].getPrizeMoney()) + "원)" + " - " + values[i].getCount() + "개");
            } else {
                System.out.println(values[i].getRank() + "개 일치 "
                        + "(" + df.format(values[i].getPrizeMoney()) + "원)" + " - " + values[i].getCount() + "개");
            }
        }
    }


}
