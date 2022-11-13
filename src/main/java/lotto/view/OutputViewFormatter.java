package lotto.view;

import java.text.DecimalFormat;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.Rank;

public class OutputViewFormatter {

    private static final String MATCH_COUNT_FORMAT = "%s개 일치";
    private static final DecimalFormat MONEY_DECIMAL_FORMAT = new DecimalFormat("#,###");
    private static final String MATCH_BONUS_NUMBER_GUIDE = ", 보너스 볼 일치";
    private static final String REWARD_FORMAT = " (%s원)";
    private static final String COUNT_FORMAT = " - %s개";


    public String outputLottoFormat(Lotto lotto) {
        return lotto.numbers().stream()
                .sorted()
                .collect(Collectors.toList())
                .toString();
    }

    public String outputRankFormat(Rank rank, int count) {
        StringBuilder result = new StringBuilder();
        result.append(String.format(MATCH_COUNT_FORMAT, rank.matchCount()));
        if (rank.matchBonusNumber()) {
            result.append(MATCH_BONUS_NUMBER_GUIDE);
        }
        result.append(String.format(REWARD_FORMAT, outputMoneyFormat(rank.reward())));
        result.append(String.format(COUNT_FORMAT, count));
        return result.toString();
    }

    public String outputMoneyFormat(Money money) {
        return MONEY_DECIMAL_FORMAT.format(money.value());
    }
}
