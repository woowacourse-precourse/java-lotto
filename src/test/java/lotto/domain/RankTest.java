package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class RankTest {
    @DisplayName("당첨 되는 경우 테스트")
    @MethodSource("winningRankData")
    @ParameterizedTest(name = "예상: {0}, 실제: {1}")
    void winningRank(Rank realRank, Rank expectRank) {
        assertThat(realRank).isEqualTo(expectRank);
    }

    @DisplayName("당첨 되지 않는 경우 테스트")
    @MethodSource("nonWinningRankData")
    @ParameterizedTest(name = "예상: {0}, 실제: {1}")
    void nonWinningRank(Rank realRank, Rank expectRank) {
        assertThat(realRank).isEqualTo(expectRank);
    }

    static Stream<Arguments> winningRankData() {
        return Stream.of(
                Arguments.of(Rank.decide(6, false), Rank.FIRST),
                Arguments.of(Rank.decide(5, true), Rank.SECOND),
                Arguments.of(Rank.decide(5, false), Rank.THIRD),
                Arguments.of(Rank.decide(4, false), Rank.FOURTH),
                Arguments.of(Rank.decide(4, true), Rank.FOURTH),
                Arguments.of(Rank.decide(3, false), Rank.FIFTH),
                Arguments.of(Rank.decide(3, true), Rank.FIFTH)
        );
    }

    static Stream<Arguments> nonWinningRankData() {
        return Stream.of(
                Arguments.of(Rank.decide(2, false), Rank.NONE),
                Arguments.of(Rank.decide(1, false), Rank.NONE),
                Arguments.of(Rank.decide(0, false), Rank.NONE)
        );
    }
}