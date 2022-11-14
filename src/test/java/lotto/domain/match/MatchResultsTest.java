package lotto.domain.match;

import static lotto.domain.match.Reward.FIFTH;
import static lotto.domain.match.Reward.FIRST;
import static lotto.domain.match.Reward.FOURTH;
import static lotto.domain.match.Reward.SECOND;
import static lotto.domain.match.Reward.THIRD;

import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MatchResultsTest {

    static Stream<Arguments> provideGetTotalPriceArguments() {
        return Stream.of(
                Arguments.of(new MatchResults(List.of()), 0),
                Arguments.of(new MatchResults(List.of(FIRST)), 2_000_000_000L),
                Arguments.of(new MatchResults(List.of(SECOND)), 30_000_000L),
                Arguments.of(new MatchResults(List.of(THIRD)), 1_500_000L),
                Arguments.of(new MatchResults(List.of(FOURTH)), 50_000L),
                Arguments.of(new MatchResults(List.of(FIFTH)), 5_000L),
                Arguments.of(new MatchResults(
                        List.of(FIRST, SECOND, THIRD, FOURTH, FIFTH, FIRST, SECOND, THIRD, FOURTH,
                                FIFTH)), 4_063_110_000L),
                Arguments.of(new MatchResults(List.of(FIRST, SECOND, THIRD, FOURTH, FIFTH)),
                        2_031_555_000L));
    }

    @ParameterizedTest(name = "getTotalPrice[{index}]: {0}, {1}")
    @MethodSource("provideGetTotalPriceArguments")
    void getTotalPrice(MatchResults results, long expect) {
        long totalPrice = results.getTotalPrice();

        Assertions.assertThat(totalPrice).isEqualTo(expect);
    }

    static Stream<Arguments> provideGetCountArguments() {
        MatchResults results = new MatchResults(
                List.of(SECOND, THIRD, THIRD, FOURTH, FOURTH, FOURTH, FIFTH, FIFTH, FIFTH, FIFTH));

        return Stream.of(
                Arguments.of(results, FIRST, 0),
                Arguments.of(results, SECOND, 1),
                Arguments.of(results, THIRD, 2),
                Arguments.of(results, FOURTH, 3),
                Arguments.of(results, FIFTH, 4));
    }

    @ParameterizedTest(name = "getCount[{index}]: {0}, {1}, {2}")
    @MethodSource("provideGetCountArguments")
    void getCount(MatchResults results, Reward reward, int expect) {
        int count = results.getCount(reward);

        Assertions.assertThat(count).isEqualTo(expect);
    }
}