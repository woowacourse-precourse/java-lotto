package lotto.domain;

import lotto.utils.Ranking;
import lotto.view.outputView.LottoRankingOutputView;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedHashMap;
import java.util.Map;

public class RankingCount {
    private Map<String, Integer> rankingCount = new LinkedHashMap<>();

    public RankingCount() {
        for (Ranking ranking : Ranking.values()) {
            rankingCount.put(ranking.name(), 0);
        }
    }

    public void plusRankingCount(String rank) {
        rankingCount.put(rank, rankingCount.get(rank) + 1);
    }

    public void showRankingCount() {
        StringBuffer rankingInfo = new StringBuffer();
        rankingInfo.append("당첨통계")
                .append("\n")
                .append("---")
                .append("\n");
        for (String rank : rankingCount.keySet()) {
            rankingInfo.append(Ranking.valueOf(rank).getPrintFormat())
                    .append(" - ")
                    .append(rankingCount.get(rank))
                    .append("개")
                    .append("\n");
        }
        LottoRankingOutputView.showLottoRankingInfo(rankingInfo);
    }

    public double calculateYield(int paymentMoney) {
        BigDecimal totalYield = new BigDecimal(0);
        for (String rank : rankingCount.keySet()) {
            totalYield = totalYield.add(calculateEachRankYield(paymentMoney, rank));
        }
        return totalYield.setScale(1, RoundingMode.HALF_UP).doubleValue();
    }

    private BigDecimal calculateEachRankYield(int paymentMoney, String rank) {
        BigDecimal yield = new BigDecimal(0);
        for (int count = 0; count < rankingCount.get(rank); count++) {
            double eachYield = Ranking.valueOf(rank).getPrice() / (paymentMoney * 0.01);
            yield = yield.add(new BigDecimal(eachYield));
        }
        return yield;
    }
}
