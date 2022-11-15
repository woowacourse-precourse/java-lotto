package lotto.domain.statistics;


import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.statistics.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RankTest {

    @DisplayName("일치하는 숫자의 개수와 보너스볼의 존재유무는 등수를 반환한다.")
    @ParameterizedTest
    @CsvSource({
        "0, false, NOTHING",
        "1, false, NOTHING",
        "2, false, NOTHING",
        "3, false, FIFTH",
        "4, false, FOURTH",
        "5, false, THIRD",
        "5, true,  SECOND",
        "6, false, FIRST",
    })
    void 순위_검증_테스트(int equalCnt, boolean isBonus, Rank expected) {
        Rank rank = Rank.of(equalCnt,isBonus);
        assertThat(rank).isEqualTo(expected);
    }
}
