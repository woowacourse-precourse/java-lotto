package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import lotto.model.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RankTest {

    @DisplayName("랭킹 테스트")
    @Test
    void ranktest(){
        assertThat(Rank.valueOf(3,false)).isEqualTo(Rank.FIFTH);
        assertThat(Rank.valueOf(3,true)).isEqualTo(Rank.FIFTH);
        assertThat(Rank.valueOf(4,false)).isEqualTo(Rank.FOURTH);
        assertThat(Rank.valueOf(5,false)).isEqualTo(Rank.THIRD);
        assertThat(Rank.valueOf(5,true)).isEqualTo(Rank.SECOND);
        assertThat(Rank.valueOf(6,false)).isEqualTo(Rank.FIRST);
    }
}
