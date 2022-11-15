package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RankingTest {


    @ParameterizedTest(name = "[정상] {0}개 일치, 보너스 번호 맟춤 {1}일 때, [{2}]를 반환한다.")
    @MethodSource("generateData")
    void getRankingByMatchCountAndBonusNumberHit(int matchCount, boolean bonusHit, Ranking expected) {
        assertThat(Ranking.getRanking(matchCount, bonusHit))
                .isEqualTo(expected);
    }

    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of(6, true, Ranking.FIRST_PLACE),
                Arguments.of(6, false, Ranking.FIRST_PLACE),
                Arguments.of(5, true, Ranking.SECOND_PLACE),
                Arguments.of(5, false, Ranking.THIRD_PLACE),
                Arguments.of(4, true, Ranking.FOURTH_PLACE),
                Arguments.of(4, false, Ranking.FOURTH_PLACE),
                Arguments.of(3, true, Ranking.FIFTH_PLACE),
                Arguments.of(3, false, Ranking.FIFTH_PLACE),
                Arguments.of(2, true, Ranking.NOTHING),
                Arguments.of(2, false, Ranking.NOTHING),
                Arguments.of(1, true, Ranking.NOTHING),
                Arguments.of(1, false, Ranking.NOTHING),
                Arguments.of(0, true, Ranking.NOTHING),
                Arguments.of(0, false, Ranking.NOTHING)
        );
    }
}
