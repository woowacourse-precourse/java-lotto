package lotto.domain;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import static lotto.domain.Rank.SECOND;

public class LottoResultSummary {

    private static final String MATCH_NUMBER = "%d개 일치";
    private static final String BONUS_MATCH = ", 보너스 볼 일치";
    private static final String PRICE = " (%s원)";
    private static final String MATCH_COUNT = " - %d개\n";
    private static final String YIELD = "총 수익률은 %s%%입니다.";
    private static final String YIELD_PATTERN = "#,##0.0";
    private static final String MONEY_PATTERN = "#,###";
    private static final int PERCENT = 100;

    private final double yield;
    private final String summary;

    public LottoResultSummary(List<Rank> ranks, Money money) {
        yield = calculateYield(ranks, money);
        summary = summaryResult(ranks);
    }

    private double calculateYield(List<Rank> ranks, Money money) {
        double purchaseAmount = money.getMoney();
        if (purchaseAmount == 0) {
            return 0.;
        }
        AtomicLong sum = new AtomicLong();

        ranks.forEach(rank -> sum.addAndGet(rank.getPrice()));
        return sum.get() / purchaseAmount * PERCENT;
    }

    private String summaryResult(List<Rank> ranks) {
        StringBuilder sb = new StringBuilder();
        addRankSummary(ranks, sb);
        addYieldSummary(sb);
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

    private void addBonusMessageIfSecondPlace(Rank rank, StringBuilder sb) {
        if (SECOND.equals(rank)) {
            sb.append(BONUS_MATCH);
        }
    }

    private void addYieldSummary(StringBuilder sb) {
        DecimalFormat format = new DecimalFormat(YIELD_PATTERN);
        String formattedYield = format.format(yield);

        sb.append(String.format(YIELD, formattedYield));
    }

    public String summaryLottoResult() {
        return summary;
    }
}
