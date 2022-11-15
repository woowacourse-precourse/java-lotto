package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class RankTest {

    private static Stream<Arguments> getRanks() {
        return Stream.of(Arguments.of(6, false, Rank.FIRST_PRIZE),
                Arguments.of(5, true, Rank.SECOND_PRIZE),
                Arguments.of(5, false, Rank.THIRD_PRIZE),
                Arguments.of(4, false, Rank.FOURTH_PRIZE),
                Arguments.of(4, true, Rank.FOURTH_PRIZE),
                Arguments.of(3, false, Rank.FIFTH_PRIZE),
                Arguments.of(3, true, Rank.FIFTH_PRIZE),
                Arguments.of(2, true, Rank.MISS),
                Arguments.of(0, false, Rank.MISS));
    }

    @DisplayName("맞춘 번호 수에 따라 로또 순위를 반환")
    @ParameterizedTest
    @MethodSource("getRanks")
    void get_ranks(int matchCounts, boolean isBonusBall, Rank rank) {
        Rank value = Rank.of(matchCounts, isBonusBall);

        assertThat(value).isEqualTo(rank);
    }
}
