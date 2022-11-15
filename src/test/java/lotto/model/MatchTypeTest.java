package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MatchTypeTest {
    @DisplayName("일치하는 숫자 개수로 MatchType 이 생성되어야 한다.")
    @Test
    void createMatchTypeFromNumberMatched() {
        assertThat(MatchType.fromNumberMatched(3.0)).isEqualTo(MatchType.THREE);
        assertThat(MatchType.fromNumberMatched(4.0)).isEqualTo(MatchType.FOUR);
        assertThat(MatchType.fromNumberMatched(5.0)).isEqualTo(MatchType.FIVE);
        assertThat(MatchType.fromNumberMatched(5.5)).isEqualTo(MatchType.FIVE_BONUS);
        assertThat(MatchType.fromNumberMatched(6.0)).isEqualTo(MatchType.SIX);
    }

    @DisplayName("일치하는 숫자 개수가 3개 미만이면 null 이 생성되어야 한다.")
    @Test
    void createMatchTypeByNumberMatchedUnderThree() {
        assertThat(MatchType.fromNumberMatched(2.0)).isEqualTo(null);
    }

    @DisplayName("일치하는 숫자 개수가 6개 초과면 null 이 생성되어야 한다.")
    @Test
    void createMatchTypeByNumberMatchedOverSix() {
        assertThat(MatchType.fromNumberMatched(7.0)).isEqualTo(null);
    }
}