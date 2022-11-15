package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RankingTest {
    @DisplayName("1등 테스트")
    @Test
    void checkFirstPlace() {
        int matchNum = 6;
        boolean bonus = false;

        assertThat(Ranking.getRank(matchNum, bonus))
                .isEqualTo(Ranking.FIRST_PLACE);
    }

    @DisplayName("2등 테스트")
    @Test
    void checkSecondPlace() {
        int matchNum = 5;
        boolean bonus = true;

        assertThat(Ranking.getRank(matchNum, bonus))
                .isEqualTo(Ranking.SECOND_PLACE);
    }

    @DisplayName("3등 테스트")
    @Test
    void checkThirdPlace() {
        int matchNum = 5;
        boolean bonus = false;

        assertThat(Ranking.getRank(matchNum, bonus))
                .isEqualTo(Ranking.THIRD_PLACE);
    }

    @DisplayName("4등 테스트")
    @Test
    void checkFourthPlace() {
        int matchNum = 4;
        boolean bonus = false;

        assertThat(Ranking.getRank(matchNum, bonus))
                .isEqualTo(Ranking.FOURTH_PLACE);
    }

    @DisplayName("5등 테스트")
    @Test
    void checkFifthPlace() {
        int matchNum = 3;
        boolean bonus = true;

        assertThat(Ranking.getRank(matchNum, bonus))
                .isEqualTo(Ranking.FIFTH_PLACE);
    }

    @DisplayName("꽝 테스트")
    @Test
    void checkOutOfRanking() {
        int matchNum = 2;
        boolean bonus = true;

        assertThat(Ranking.getRank(matchNum, bonus))
                .isEqualTo(Ranking.NOT_RANKED);
    }
}