package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoRankTest {


    @ParameterizedTest(name = "[정상] {0}개 일치, 보너스 번호 맟춤 {1}일 때, [{2}]를 반환한다.")
    @MethodSource("generateData")
    void getLottoRankByMatchCountAndBonusNumberHit(int matchCount, boolean bonusHit, LottoRank expected) {
        assertThat(LottoRank.getLottoRank(matchCount, bonusHit))
                .isEqualTo(expected);
    }

    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of(6, true, LottoRank.FIRST_PLACE),
                Arguments.of(6, false, LottoRank.FIRST_PLACE),
                Arguments.of(5, true, LottoRank.SECOND_PLACE),
                Arguments.of(5, false, LottoRank.THIRD_PLACE),
                Arguments.of(4, true, LottoRank.FOURTH_PLACE),
                Arguments.of(4, false, LottoRank.FOURTH_PLACE),
                Arguments.of(3, true, LottoRank.FIFTH_PLACE),
                Arguments.of(3, false, LottoRank.FIFTH_PLACE),
                Arguments.of(2, true, LottoRank.NOTHING),
                Arguments.of(2, false, LottoRank.NOTHING),
                Arguments.of(1, true, LottoRank.NOTHING),
                Arguments.of(1, false, LottoRank.NOTHING),
                Arguments.of(0, true, LottoRank.NOTHING),
                Arguments.of(0, false, LottoRank.NOTHING)
        );
    }
}
