package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @DisplayName("보너스 볼이 맞지 않았을 때 로또 맞은 개수에 따라 등수를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"1,NONE", "2,NONE", "3,FIFTH", "4,FOURTH", "5,THIRD", "6,FIRST"})
    void findRank(int input, Rank expected) {
        assertThat(Rank.findRank(input, false)).isEqualTo(expected);
    }

    @DisplayName("보너스 볼이 맞았을 때 로또 번호 5개가 맞으면 2등을 반환한다.")
    @Test
    void findSecond() {
        assertThat(Rank.findRank(5, true)).isEqualTo(Rank.SECOND);
    }
}
