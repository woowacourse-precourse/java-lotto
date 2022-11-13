package lotto.model;

import static lotto.model.Rank.FIFTH_PLACE;
import static lotto.model.Rank.findCountWithRank;
import static lotto.model.Rank.findRewardWithRank;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RankTest {
    @Test
    @DisplayName("겹치는 횟수에 따라 알맞는 순위를 반환한다.")
    void checkFindRankWithCount() {
        //given
        int duplicateCount = 3;

        //when
        Rank result = Rank.findRankWithCount(duplicateCount);

        //then
        assertThat(result).isEqualTo(FIFTH_PLACE);
    }

    @Test
    @DisplayName("순위에 따라 알맞는 겹치는 횟수를 반환한다.")
    void checkFindCountWithRank() {
        //given
        Rank rank = FIFTH_PLACE;

        //when
        int duplicateCount = findCountWithRank(rank);

        //then
        assertThat(duplicateCount).isEqualTo(3);
    }

    @Test
    @DisplayName("순위에 따라 알맞는 상금을 반환한다.")
    void checkFindRewardWithRank() {
        //given
        Rank rank = FIFTH_PLACE;

        //when
        int reward = findRewardWithRank(rank);

        //then
        assertThat(reward).isEqualTo(5000);
    }
}
