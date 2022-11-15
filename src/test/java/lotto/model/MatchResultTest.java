package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MatchResultTest {
    Map<MatchType, Integer> matchResult = new EnumMap<>(MatchType.class);

    void setMatchResult(int three, int four, int five, int fiveBonus, int six) {
        matchResult.put(MatchType.THREE, three);
        matchResult.put(MatchType.FOUR, four);
        matchResult.put(MatchType.FIVE, five);
        matchResult.put(MatchType.FIVE_BONUS, fiveBonus);
        matchResult.put(MatchType.SIX, six);
    }

    @DisplayName("등수 하나 상금 계산")
    @Test
    void getTotalPrizeMoney() {
        setMatchResult(1, 0, 0, 0, 0);
        MatchResult result = new MatchResult(matchResult);
        assertThat(result.getTotalPrizeMoney())
                .isEqualTo(MatchType.THREE.getPrizeMoney());

        setMatchResult(0, 1, 0, 0, 0);
        result = new MatchResult(matchResult);
        assertThat(result.getTotalPrizeMoney())
                .isEqualTo(MatchType.FOUR.getPrizeMoney());

        setMatchResult(0, 0, 1, 0, 0);
        result = new MatchResult(matchResult);
        assertThat(result.getTotalPrizeMoney())
                .isEqualTo(MatchType.FIVE.getPrizeMoney());

        setMatchResult(0, 0, 0, 1, 0);
        result = new MatchResult(matchResult);
        assertThat(result.getTotalPrizeMoney())
                .isEqualTo(MatchType.FIVE_BONUS.getPrizeMoney());

        setMatchResult(0, 0, 0, 0, 1);
        result = new MatchResult(matchResult);
        assertThat(result.getTotalPrizeMoney())
                .isEqualTo(MatchType.SIX.getPrizeMoney());

    }

    @DisplayName("1,2,3,4,5 등 상금 계산")
    @Test
    void getTotalPrizeMoneyWhenAllMatched() {
        setMatchResult(1, 1, 1, 1, 1);
        MatchResult result = new MatchResult(matchResult);
        assertThat(result.getTotalPrizeMoney()).isEqualTo(
                Arrays.stream(MatchType.values())
                        .map(MatchType::getPrizeMoney)
                        .mapToDouble(Integer::doubleValue)
                        .sum()
        );
    }
}