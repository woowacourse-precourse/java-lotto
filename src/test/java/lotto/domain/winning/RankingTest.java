package lotto.domain.winning;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RankingTest {

    private static Stream<Arguments> provideArgumentsForRankingMethod() {
        return Stream.of(
                Arguments.of(6, false, Ranking.FIRST),
                Arguments.of(5, true, Ranking.SECOND),
                Arguments.of(5, false, Ranking.THIRD),
                Arguments.of(4, true, Ranking.FORTH),
                Arguments.of(3, false, Ranking.FIFTH)
        );
    }

    @ParameterizedTest(name = "{0}, {1}이 입력되면 결과는 {2}가 나온다.")
    @MethodSource("provideArgumentsForRankingMethod")
    void lottoRankingFindByMatchNumberCount(int matcounts, boolean isMatchedBonus,
            Ranking expected) {
        Ranking actual = Ranking.ranking(matcounts, isMatchedBonus);
        assertThat(actual).isEqualTo(expected);
    }
}