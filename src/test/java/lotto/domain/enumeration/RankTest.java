package lotto.domain.enumeration;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class RankTest {
    @Test
    void 올바른_등수_체크() {
        //given
        int count = 4;
        boolean bonus = true;

        //when
        Rank rank = Rank.of(count, bonus);

        //then
        assertThat(Rank.FOURTH).isEqualTo(rank);
    }
}
