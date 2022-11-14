package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import type.Rank;

import static org.assertj.core.api.Assertions.assertThat;


public class RankTest {

    @DisplayName("해당하는 count가 없을 경우 NOTHING을 반환한다.")
    @Test
    void getNOTHING() {
        assertThat(Rank.findRankByCount(1)).isEqualTo(Rank.NOTHING);
    }

    @DisplayName("해당하는 count 있을 경우 맞는 RANK를 반환한다.")
    @Test
    void getRANK() {
        assertThat(Rank.findRankByCount(3)).isEqualTo(Rank.FIFTH);
    }
}
