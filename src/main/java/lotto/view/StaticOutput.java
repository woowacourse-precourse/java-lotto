package lotto.view;

import java.text.DecimalFormat;
import java.util.Collections;
import java.util.List;
import lotto.model.LottoRank;

public class StaticOutput {
    private static final DecimalFormat MONETARY_FORMAT = new DecimalFormat("###,###");
    private static final String STATIC_FORMAT = "%s (%s원) - %d개";

    public static void printStatistics(List<LottoRank> lottoRanks, double roi) {
        System.out.println("당첨 통계\n---");
        for (LottoRank rank : LottoRank.values()) {
            int count = Collections.frequency(lottoRanks, rank);
            System.out.println(String.format(STATIC_FORMAT,
                    rank.getCondition(), MONETARY_FORMAT.format(rank.getPrize()), count));
        }
        System.out.println(String.format("총 수익률은 %.1f%%입니다.", roi * 100));
    }
}
