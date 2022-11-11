package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RankTest {
    @Test
    void printRankInfo() {
        //given
        Rank[] rankings = Rank.values();
        //when,then
        for (Rank rank : rankings) {
            System.out.print(rank);
            System.out.println("  Prize : " + rank.getPrize());
        }
    }

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
}