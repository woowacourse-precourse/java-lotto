package lotto.domain;

import java.util.Optional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RankTest {
    @DisplayName("Rank의 개수 증가")
    @Test
    void plusRankCount() {
        //given
        //when
        Rank.FIRST_PLACE.plusCount();
        Rank.FIRST_PLACE.plusCount();
        Rank.SECOND_PLACE.plusCount();

        //then
        Assertions.assertThat(Rank.FIRST_PLACE.getCount())
                .isEqualTo(2);
    }

    @DisplayName("matchRank 메소드 테스트")
    @Test
    void matchRank(){
        //given
        //when
        Optional<Rank> matchRanking = Rank.matchRank(5, true);
        Rank rank = matchRanking.get();

        //then
        Assertions.assertThat(rank).isEqualTo(Rank.SECOND_PLACE);
    }
}