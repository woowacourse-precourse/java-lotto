package lotto.domain.result;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RankTest {

    @ParameterizedTest
    @CsvSource({
            "3, false, 'THREE_MATCHES'",
            "4, false, 'FOUR_MATCHES'",
            "5, true, 'FIVE_MATCHES_WITH_BONUS'",
            "5, false, 'FIVE_MATCHES_WITHOUT_BONUS'",
            "6, false, 'SIX_MATCHES'",
            "2, false, 'NONE'",
            "10, false, 'NONE'"
    })
    public void getRank(int hitCount, boolean hasBonusNumber, String rank) {
        assertThat(Rank.getRank(hitCount, hasBonusNumber).toString())
                .isEqualTo(rank);
    }
}
