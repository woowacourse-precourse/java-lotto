package lotto.domain;

import static lotto.domain.Ranking.FIFTH;
import static lotto.domain.Ranking.FIRST;
import static lotto.domain.Ranking.FOURTH;
import static lotto.domain.Ranking.SECOND;
import static lotto.domain.Ranking.THIRD;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RankingTest {

    @Test
    void generateRankings() {
        List<Ranking> expected = Arrays.asList(FIFTH, FOURTH, THIRD, SECOND, FIRST);

        List<Ranking> actual = Ranking.generateRankings();
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("Ranking 가져오기")
    void getRanking() {
        int count = 5;
        boolean existBonusNumber = true;

        int expectedMoney = 30000000;
        int expectedCount = 5;
        boolean expectedBonusNumber = true;

        Ranking actual = Ranking.getRanking(count, existBonusNumber);
        Assertions.assertThat(actual.getMoney()).isEqualTo(expectedMoney);
        Assertions.assertThat(actual.getCount()).isEqualTo(expectedCount);
        Assertions.assertThat(actual.isExistBonusNumber()).isEqualTo(expectedBonusNumber);
    }
}