package lotto.domainTest;

import lotto.domain.Ranking;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RankingTest {

    @Test
    @DisplayName("로또 1등 인지 확인하는 테스트")
    void checkRanking1() {
        // given
        int sameNumberCount = 6;
        boolean hasBonusNumber = false;
        // when
        Ranking ranking = Ranking.matchRanking(sameNumberCount, hasBonusNumber);
        //then
        Assertions.assertThat(ranking).isEqualTo(Ranking.FIRST);
    }

    @Test
    @DisplayName("로또 2등 인지 확인하는 테스트")
    void checkRanking2() {
        // given
        int sameNumberCount = 5;
        boolean hasBonusNumber = true;
        // when
        Ranking ranking = Ranking.matchRanking(sameNumberCount, hasBonusNumber);
        //then
        Assertions.assertThat(ranking).isEqualTo(Ranking.SECOND);
    }

    @Test
    @DisplayName("로또 3등 인지 확인하는 테스트")
    void checkRanking3() {
        // given
        int sameNumberCount = 5;
        boolean hasBonusNumber = false;
        // when
        Ranking ranking = Ranking.matchRanking(sameNumberCount, hasBonusNumber);
        //then
        Assertions.assertThat(ranking).isEqualTo(Ranking.THIRD);
    }

    @Test
    @DisplayName("로또 4등 인지 확인하는 테스트")
    void checkRanking4() {
        // given
        int sameNumberCount = 4;
        boolean hasBonusNumber = false;
        // when
        Ranking ranking = Ranking.matchRanking(sameNumberCount, hasBonusNumber);
        //then
        Assertions.assertThat(ranking).isEqualTo(Ranking.FOURTH);
    }

    @Test
    @DisplayName("로또 5등 인지 확인하는 테스트")
    void checkRanking5() {
        // given
        int sameNumberCount = 3;
        boolean hasBonusNumber = false;
        // when
        Ranking ranking = Ranking.matchRanking(sameNumberCount, hasBonusNumber);
        //then
        Assertions.assertThat(ranking).isEqualTo(Ranking.FIFTH);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    @DisplayName("로또 낙첨 인지 확인하는 테스트")
    void checkRanking6(int sameNumberCount) {
        // given
        boolean hasBonusNumber = false;
        // when
        Ranking ranking = Ranking.matchRanking(sameNumberCount, hasBonusNumber);
        //then
        Assertions.assertThat(ranking).isEqualTo(Ranking.NOTHING);
    }
}
