package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import lotto.constant.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RankTest {
    @DisplayName("1등을 제대로 판단하는지 확인한다.")
    @Test
    void rankFirst() {
        assertAll(
                () -> assertThat(Rank.FIRST.getWinning(0, false)).isEqualTo(null),
                () -> assertThat(Rank.FIRST.getWinning(0, true)).isEqualTo(null),
                () -> assertThat(Rank.FIRST.getWinning(1, false)).isEqualTo(null),
                () -> assertThat(Rank.FIRST.getWinning(1, true)).isEqualTo(null),
                () -> assertThat(Rank.FIRST.getWinning(2, false)).isEqualTo(null),
                () -> assertThat(Rank.FIRST.getWinning(2, true)).isEqualTo(null),
                () -> assertThat(Rank.FIRST.getWinning(3, false)).isEqualTo(null),
                () -> assertThat(Rank.FIRST.getWinning(3, true)).isEqualTo(null),
                () -> assertThat(Rank.FIRST.getWinning(4, false)).isEqualTo(null),
                () -> assertThat(Rank.FIRST.getWinning(4, true)).isEqualTo(null),
                () -> assertThat(Rank.FIRST.getWinning(5, false)).isEqualTo(null),
                () -> assertThat(Rank.FIRST.getWinning(5, true)).isEqualTo(null),
                () -> assertThat(Rank.FIRST.getWinning(6, false)).isEqualTo(2000000000)
        );
    }

    @DisplayName("2등을 제대로 판단하는지 확인한다.")
    @Test
    void rankSecond() {
        assertAll(
                () -> assertThat(Rank.SECOND.getWinning(0, false)).isEqualTo(null),
                () -> assertThat(Rank.SECOND.getWinning(0, true)).isEqualTo(null),
                () -> assertThat(Rank.SECOND.getWinning(1, false)).isEqualTo(null),
                () -> assertThat(Rank.SECOND.getWinning(1, true)).isEqualTo(null),
                () -> assertThat(Rank.SECOND.getWinning(2, false)).isEqualTo(null),
                () -> assertThat(Rank.SECOND.getWinning(2, true)).isEqualTo(null),
                () -> assertThat(Rank.SECOND.getWinning(3, false)).isEqualTo(null),
                () -> assertThat(Rank.SECOND.getWinning(3, true)).isEqualTo(null),
                () -> assertThat(Rank.SECOND.getWinning(4, false)).isEqualTo(null),
                () -> assertThat(Rank.SECOND.getWinning(4, true)).isEqualTo(null),
                () -> assertThat(Rank.SECOND.getWinning(5, false)).isEqualTo(null),
                () -> assertThat(Rank.SECOND.getWinning(5, true)).isEqualTo(30000000),
                () -> assertThat(Rank.SECOND.getWinning(6, false)).isEqualTo(null)
        );
    }

    @DisplayName("4등을 제대로 판단하는지 확인한다.")
    @Test
    void rankThird() {
        assertAll(
                () -> assertThat(Rank.THIRD.getWinning(0, false)).isEqualTo(null),
                () -> assertThat(Rank.THIRD.getWinning(0, true)).isEqualTo(null),
                () -> assertThat(Rank.THIRD.getWinning(1, false)).isEqualTo(null),
                () -> assertThat(Rank.THIRD.getWinning(1, true)).isEqualTo(null),
                () -> assertThat(Rank.THIRD.getWinning(2, false)).isEqualTo(null),
                () -> assertThat(Rank.THIRD.getWinning(2, true)).isEqualTo(null),
                () -> assertThat(Rank.THIRD.getWinning(3, false)).isEqualTo(null),
                () -> assertThat(Rank.THIRD.getWinning(3, true)).isEqualTo(null),
                () -> assertThat(Rank.THIRD.getWinning(4, false)).isEqualTo(null),
                () -> assertThat(Rank.THIRD.getWinning(4, true)).isEqualTo(null),
                () -> assertThat(Rank.THIRD.getWinning(5, false)).isEqualTo(1500000),
                () -> assertThat(Rank.THIRD.getWinning(5, true)).isEqualTo(null),
                () -> assertThat(Rank.THIRD.getWinning(6, false)).isEqualTo(null)
        );
    }

    @DisplayName("4등을 제대로 판단하는지 확인한다.")
    @Test
    void rankFourth() {
        assertAll(
                () -> assertThat(Rank.FOURTH.getWinning(0, false)).isEqualTo(null),
                () -> assertThat(Rank.FOURTH.getWinning(0, true)).isEqualTo(null),
                () -> assertThat(Rank.FOURTH.getWinning(1, false)).isEqualTo(null),
                () -> assertThat(Rank.FOURTH.getWinning(1, true)).isEqualTo(null),
                () -> assertThat(Rank.FOURTH.getWinning(2, false)).isEqualTo(null),
                () -> assertThat(Rank.FOURTH.getWinning(2, true)).isEqualTo(null),
                () -> assertThat(Rank.FOURTH.getWinning(3, false)).isEqualTo(null),
                () -> assertThat(Rank.FOURTH.getWinning(3, true)).isEqualTo(null),
                () -> assertThat(Rank.FOURTH.getWinning(4, false)).isEqualTo(50000),
                () -> assertThat(Rank.FOURTH.getWinning(4, true)).isEqualTo(50000),
                () -> assertThat(Rank.FOURTH.getWinning(5, false)).isEqualTo(null),
                () -> assertThat(Rank.FOURTH.getWinning(5, true)).isEqualTo(null),
                () -> assertThat(Rank.FOURTH.getWinning(6, false)).isEqualTo(null)
        );
    }

    @DisplayName("5등을 제대로 판단하는지 확인한다.")
    @Test
    void rankFifth() {
        assertAll(
                () -> assertThat(Rank.FIFTH.getWinning(0, false)).isEqualTo(null),
                () -> assertThat(Rank.FIFTH.getWinning(0, true)).isEqualTo(null),
                () -> assertThat(Rank.FIFTH.getWinning(1, false)).isEqualTo(null),
                () -> assertThat(Rank.FIFTH.getWinning(1, true)).isEqualTo(null),
                () -> assertThat(Rank.FIFTH.getWinning(2, false)).isEqualTo(null),
                () -> assertThat(Rank.FIFTH.getWinning(2, true)).isEqualTo(null),
                () -> assertThat(Rank.FIFTH.getWinning(3, false)).isEqualTo(5000),
                () -> assertThat(Rank.FIFTH.getWinning(3, true)).isEqualTo(5000),
                () -> assertThat(Rank.FIFTH.getWinning(4, false)).isEqualTo(null),
                () -> assertThat(Rank.FIFTH.getWinning(4, true)).isEqualTo(null),
                () -> assertThat(Rank.FIFTH.getWinning(5, false)).isEqualTo(null),
                () -> assertThat(Rank.FIFTH.getWinning(5, true)).isEqualTo(null),
                () -> assertThat(Rank.FIFTH.getWinning(6, false)).isEqualTo(null)
        );
    }

    @DisplayName("6등을 제대로 판단하는지 확인한다.")
    @Test
    void rankSixth() {
        assertAll(
                () -> assertThat(Rank.SIXTH.getWinning(0, false)).isEqualTo(0),
                () -> assertThat(Rank.SIXTH.getWinning(0, true)).isEqualTo(0),
                () -> assertThat(Rank.SIXTH.getWinning(1, false)).isEqualTo(0),
                () -> assertThat(Rank.SIXTH.getWinning(1, true)).isEqualTo(0),
                () -> assertThat(Rank.SIXTH.getWinning(2, false)).isEqualTo(0),
                () -> assertThat(Rank.SIXTH.getWinning(2, true)).isEqualTo(0),
                () -> assertThat(Rank.SIXTH.getWinning(3, false)).isEqualTo(null),
                () -> assertThat(Rank.SIXTH.getWinning(3, true)).isEqualTo(null),
                () -> assertThat(Rank.SIXTH.getWinning(4, false)).isEqualTo(null),
                () -> assertThat(Rank.SIXTH.getWinning(4, true)).isEqualTo(null),
                () -> assertThat(Rank.SIXTH.getWinning(5, false)).isEqualTo(null),
                () -> assertThat(Rank.SIXTH.getWinning(5, true)).isEqualTo(null),
                () -> assertThat(Rank.SIXTH.getWinning(6, false)).isEqualTo(null)
        );
    }
}
