package lotto.domain;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import static lotto.domain.Rank.SECOND;

public class LottoSummary {

    private final static String MATCH_NUMBER = "%d개 일치";
    private final static String BONUS_MATCH = ", 보너스 볼 일치";
    private final static String PRICE = " (%s원)";
    private final static String MATCH_COUNT = " - %d개\n";
    private static final String PROFIT = "총 수익률은 %s%%입니다.";
    private static final String PROFIT_PATTERN = "#,###.0";
    private static final String MONEY_PATTERN = "#,###";

    private final double profit;
    private final String summary;

    public LottoSummary(List<Rank> ranks, Money money) {
        profit = calculateProfit(ranks, money);
        summary = summaryResult(ranks);
    }

    private double calculateProfit(List<Rank> ranks, Money money) {
        AtomicLong sum = new AtomicLong();

        ranks.forEach(rank -> sum.addAndGet(rank.getPrice()));
        return sum.get() / (double) money.getMoney() * 100;
    }

    private String summaryResult(List<Rank> ranks) {
        StringBuilder sb = new StringBuilder();
        addRankSummary(ranks, sb);
        addProfitSummary(sb);
        return sb.toString();
    }

    private void addRankSummary(List<Rank> ranks, StringBuilder sb) {
        Arrays.stream(Rank.values())
                .filter(rank -> !rank.equals(Rank.NOTHING))
                .map(rank -> makeSummaryByRank(rank, Collections.frequency(ranks, rank)))
                .forEach(sb::append);
    }

    private String makeSummaryByRank(Rank rank, int frequency) {
        StringBuilder sb = new StringBuilder();
        DecimalFormat format = new DecimalFormat(MONEY_PATTERN);
        String price = format.format(rank.getPrice());

        sb.append(String.format(MATCH_NUMBER, rank.getMatchCount()));
        addBonusMessageIfSecondPlace(rank, sb);
        sb.append(String.format(PRICE, price));
        sb.append(String.format(MATCH_COUNT, frequency));
        return sb.toString();
    }

    private static void addBonusMessageIfSecondPlace(Rank rank, StringBuilder sb) {
        if (SECOND.equals(rank)) {
            sb.append(BONUS_MATCH);
        }
    }

    private void addProfitSummary(StringBuilder sb) {
        DecimalFormat format = new DecimalFormat(PROFIT_PATTERN);
        String profitSummary = format.format(profit);

        sb.append(String.format(PROFIT, profitSummary));
    }

    @Override
    public String toString() {
        return summary;
    }
}
