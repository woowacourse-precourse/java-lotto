package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class RankTest {
    @DisplayName("enum 열거형 값들이 잘 매치 되는지 확인한다.")
    @Test
    void valueOf() {
        assertThat(Rank.valueOf(6, false)).isEqualTo(Rank.FIRST);
        assertThat(Rank.valueOf(5, true)).isEqualTo(Rank.SECOND);
        assertThat(Rank.valueOf(5, false)).isEqualTo(Rank.THIRD);
        assertThat(Rank.valueOf(4, false)).isEqualTo(Rank.FOURTH);
        assertThat(Rank.valueOf(3, false)).isEqualTo(Rank.FIFTH);
        assertThat(Rank.valueOf(2, true)).isEqualTo(Rank.NONE);
    }

    @DisplayName("최종결과 형태에 따른 내림차순으로 정렬이 되는지 확인한다.")
    @Test
    void getSortedRank() {
        assertThat(Rank.getSortedRank().toArray())
                .isEqualTo(new Rank[]{Rank.FIFTH, Rank.FOURTH, Rank.THIRD, Rank.SECOND, Rank.FIRST});
    }
}