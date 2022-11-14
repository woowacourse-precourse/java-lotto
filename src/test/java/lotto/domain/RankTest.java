package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {
    @ParameterizedTest
    @CsvSource(value={"5,true"})
    void 랭크_가져오기_테스트(int matchCount, boolean isBonus) {
        Rank rank = Rank.getRank(matchCount, isBonus);
        assertThat(rank).isEqualTo(Rank.SECOND);
    }

}