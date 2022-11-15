package lotto;

import static lotto.Message.MATCH_FIVE_NUMBERS_WITHOUT_BONUS;
import static lotto.Message.MATCH_FIVE_NUMBERS_WITH_BONUS;
import static lotto.Message.MATCH_FOUR_NUMBERS;
import static lotto.Message.MATCH_SIX_NUMBERS;
import static lotto.Message.MATCH_THREE_NUMBERS;
import static lotto.Message.STATISTICS;
import static lotto.Message.TOTAL_RETURN_ON_INVESTMENT;
import static lotto.Rank.FIFTH;
import static lotto.Rank.FIRST;
import static lotto.Rank.FOURTH;
import static lotto.Rank.SECOND;
import static lotto.Rank.THIRD;
import static lotto.Rank.values;

import java.text.DecimalFormat;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoStatistics {
    private static final int INIT_COUNT = 0;
    private static final int ONE_COUNT = 1;

    private static final String FORMATTING_LINE = "---";
    private static final String UNIT_OF_COUNT = "개";
    private static final String SUFFIX = "입니다.";

    private final WinningLotto winningLotto;
    private final List<Lotto> lottos;
    private final Map<Rank, Integer> statistics = new EnumMap<>(Rank.class);

    public LottoStatistics(WinningLotto winningLotto, List<Lotto> lottos) {
        this.winningLotto = winningLotto;
        this.lottos = lottos;

        initStatistics();

        updateStatistics();
    }

    private void initStatistics() {
        for (Rank rank : values()) {
            statistics.put(rank, INIT_COUNT);
        }
    }

    private void updateStatistics() {
        for (Lotto lotto : lottos) {
            Rank rank = winningLotto.getRankOfLotto(lotto);

            statistics.put(rank, addCount(rank));
        }
    }

    private int addCount(Rank rank) {
        return statistics.get(rank) + ONE_COUNT;
    }

    public void print() {
        System.out.println();
        System.out.println(STATISTICS.getMessage());
        System.out.println(FORMATTING_LINE);

        System.out.println(MATCH_THREE_NUMBERS.getMessage() + countOf(FIFTH) + UNIT_OF_COUNT);
        System.out.println(MATCH_FOUR_NUMBERS.getMessage() + countOf(FOURTH) + UNIT_OF_COUNT);
        System.out.println(MATCH_FIVE_NUMBERS_WITHOUT_BONUS.getMessage() + countOf(THIRD) + UNIT_OF_COUNT);
        System.out.println(MATCH_FIVE_NUMBERS_WITH_BONUS.getMessage() + countOf(SECOND) + UNIT_OF_COUNT);
        System.out.println(MATCH_SIX_NUMBERS.getMessage() + countOf(FIRST) + UNIT_OF_COUNT);

        System.out.println(TOTAL_RETURN_ON_INVESTMENT.getMessage() + getFormattedReturnOnInvestment() + SUFFIX);
    }

    private int countOf(Rank rank) {
        return statistics.get(rank);
    }

    private String getFormattedReturnOnInvestment() {
        DecimalFormat decimalFormat = new DecimalFormat("###,###,##0.0%");

        double returnOnInvestment = getReturnOnInvestment();

        return decimalFormat.format(returnOnInvestment);
    }

    private double getReturnOnInvestment() {
        double totalReturn = getTotalReturn();

        double totalInvestment = getTotalInvestment();

        return totalReturn / totalInvestment;
    }

    private double getTotalReturn() {
        double totalReturn = INIT_COUNT;

        for (Rank rank : values()) {
            totalReturn += getReturnByRank(rank);
        }

        return totalReturn;
    }

    private double getReturnByRank(Rank rank) {
        return getWinningMoneyByRank(rank) * countOf(rank);
    }

    private double getWinningMoneyByRank(Rank rank) {
        return rank.getWinningMoney();
    }

    private int getTotalInvestment() {
        return lottos.size() * Lotto.PRICE;
    }
}
