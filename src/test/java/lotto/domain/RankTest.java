package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
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
}
