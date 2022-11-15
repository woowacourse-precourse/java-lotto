package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RankTest {

    @DisplayName("5개의 숫자가 맞고 보너스 숫자가 맞으면 2등을 반환한다.")
    @Test
    void getSecondRankByCountOfMatchAndMatchBonus() {
        Integer countOfMatch = 5;
        Boolean matchBonus = true;
        assertThat(Rank.findByCountOfMatchAndMatchBonus(countOfMatch, matchBonus)).isEqualTo(Rank.SECOND);
    }
}
