package lotto.view;

import static lotto.constant.MatchType.FIVE_MATCHES_WITHOUT_BONUS;
import static lotto.constant.MatchType.FIVE_MATCHES_WITH_BONUS;
import static lotto.constant.MatchType.FOUR_MATCHES;
import static lotto.constant.MatchType.SIX_MATCHES;
import static lotto.constant.MatchType.THREE_MATCHES;
import static lotto.constant.SystemValue.FIVE_MATCHES_WITHOUT_BONUS_INDEX;
import static lotto.constant.SystemValue.FIVE_MATCHES_WITH_BONUS_INDEX;
import static lotto.constant.SystemValue.FOUR_MATCHES_INDEX;
import static lotto.constant.SystemValue.SIX_MATCHES_INDEX;
import static lotto.constant.SystemValue.THREE_MATCHES_INDEX;

import java.util.List;

public class Output {

    public void printWinningStatistics(List<Integer> matchResults) {
        System.out.printf(THREE_MATCHES.getMessage(), matchResults.get(THREE_MATCHES_INDEX));
        System.out.printf(FOUR_MATCHES.getMessage(), matchResults.get(FOUR_MATCHES_INDEX));
        System.out.printf(FIVE_MATCHES_WITHOUT_BONUS.getMessage(), matchResults.get(FIVE_MATCHES_WITHOUT_BONUS_INDEX));
        System.out.printf(FIVE_MATCHES_WITH_BONUS.getMessage(), matchResults.get(FIVE_MATCHES_WITH_BONUS_INDEX));
        System.out.printf(SIX_MATCHES.getMessage(), matchResults.get(SIX_MATCHES_INDEX));
    }
}
