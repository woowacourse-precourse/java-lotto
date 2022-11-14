package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class RankTest {

    private static Stream<Arguments> provideForResult() {
        return Stream.of(
                Arguments.of(6, false, Rank.FIRST),
                Arguments.of(5, true, Rank.SECOND),
                Arguments.of(5, false, Rank.THIRD),
                Arguments.of(4, false, Rank.FOURTH),
                Arguments.of(3, false, Rank.FIFTH),
                Arguments.of(2, false, Rank.MISS),
                Arguments.of(1, false, Rank.MISS),
                Arguments.of(0, false, Rank.MISS)
        );
    }

    @ParameterizedTest(name = "로또 번호와 보너스 번호가 일치하는지 여부로 순위를 반환한다.")
    @MethodSource("provideForResult")
    void result(int matchCount, boolean matchBonusNumber, Rank rank) {
        assertThat(Rank.result(matchCount, matchBonusNumber)).isEqualTo(rank);
    }

    @DisplayName("순위의 상금을 더한 돈을 반환한다.")
    @Test
    void reward() {
        List<Rank> ranks = List.of(Rank.FIRST, Rank.SECOND, Rank.THIRD, Rank.FOURTH, Rank.FIFTH, Rank.MISS);

        assertThat(Rank.totalReward(ranks)).isEqualTo(new Money(2_031_555_000));
    }

    private static Stream<Arguments> provideForMatchCount() {
        return Stream.of(
                Arguments.of(Rank.FIRST, 6),
                Arguments.of(Rank.SECOND, 5),
                Arguments.of(Rank.THIRD, 5),
                Arguments.of(Rank.FOURTH, 4),
                Arguments.of(Rank.FIFTH, 3),
                Arguments.of(Rank.MISS, 0)
        );
    }

    @ParameterizedTest(name = "순위의 일치하는 번호 개수를 반환한다.")
    @MethodSource("provideForMatchCount")
    void matchCount(Rank rank, int matchCount) {
        assertThat(rank.matchCount()).isEqualTo(matchCount);
    }

    private static Stream<Arguments> provideForMatchBonusNumber() {
        return Stream.of(
                Arguments.of(Rank.FIRST, false),
                Arguments.of(Rank.SECOND, true),
                Arguments.of(Rank.THIRD, false),
                Arguments.of(Rank.FOURTH, false),
                Arguments.of(Rank.FIFTH, false),
                Arguments.of(Rank.MISS, false)
        );
    }

    @ParameterizedTest(name = "보너스 번호가 일치해야 하는지 반환한다.")
    @MethodSource("provideForMatchBonusNumber")
    void matchBonusNumber(Rank rank, boolean matchBonusNumber) {
        assertThat(rank.matchBonusNumber()).isEqualTo(matchBonusNumber);
    }

    private static Stream<Arguments> provideForReward() {
        return Stream.of(
                Arguments.of(Rank.FIRST, new Money(2_000_000_000)),
                Arguments.of(Rank.SECOND, new Money(30_000_000)),
                Arguments.of(Rank.THIRD, new Money(1_500_000)),
                Arguments.of(Rank.FOURTH, new Money(50_000)),
                Arguments.of(Rank.FIFTH, new Money(5_000)),
                Arguments.of(Rank.MISS, new Money(0))
        );
    }

    @ParameterizedTest(name = "순위의 상금을 반환한다.")
    @MethodSource("provideForReward")
    void result(Rank rank, Money reward) {
        assertThat(rank.reward()).isEqualTo(reward);
    }
}
