package lotto.entity;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RankTest {

    @DisplayName("맞은 개수가 6개이고 보너스 번호가 틀린 경우 1등이다.")
    @Test
    void first() {
        //given
        Rank rank = Rank.FIRST;

        //when
        boolean result = rank.win(6, false);

        //then
        assertThat(result).isTrue();
    }

    @DisplayName("맞은 개수가 5개이고 보너스 번호가 맞은 경우 2등이다.")
    @Test
    void second() {
        //given
        Rank rank = Rank.SECOND;

        //when
        boolean result = rank.win(5, true);

        //then
        assertThat(result).isTrue();
    }

    @DisplayName("맞은 개수가 5개이고 보너스 번호가 틀린 경우 3등이다.")
    @Test
    void third() {
        //given
        Rank rank = Rank.THIRD;

        //when
        boolean result = rank.win(5, false);

        //then
        assertThat(result).isTrue();
    }

    @DisplayName("맞은 개수가 4개이고 보너스 번호가 맞은 경우 4등이다.")
    @Test
    void fourthCase1() {
        //given
        Rank rank = Rank.FOURTH;

        //when
        boolean result = rank.win(4, true);

        //then
        assertThat(result).isTrue();
    }

    @DisplayName("맞은 개수가 4개이고 보너스 번호가 틀린 경우 4등이다.")
    @Test
    void fourthCase2() {
        //given
        Rank rank = Rank.FOURTH;

        //when
        boolean result = rank.win(4, false);

        //then
        assertThat(result).isTrue();
    }

    @DisplayName("맞은 개수가 3개이고 보너스 번호가 맞은 경우 5등이다.")
    @Test
    void fifthCase1() {
        //given
        Rank rank = Rank.FIFTH;

        //when
        boolean result = rank.win(3, true);

        //then
        assertThat(result).isTrue();
    }

    @DisplayName("맞은 개수가 3개이고 보너스 번호가 틀린 경우 5등이다.")
    @Test
    void fifthCase2() {
        //given
        Rank rank = Rank.FIFTH;

        //when
        boolean result = rank.win(3, false);

        //then
        assertThat(result).isTrue();
    }

    @DisplayName("맞은 개수가 2개이고 보너스 번호가 맞은 경우 등수가 없다.")
    @Test
    void noneCase1() {
        //given
        Rank rank = Rank.NONE;

        //when
        boolean result = rank.win(2, true);

        //then
        assertThat(result).isTrue();
    }

    @DisplayName("맞은 개수가 2개이고 보너스 번호가 틀린 경우 등수가 없다.")
    @Test
    void noneCase2() {
        //given
        Rank rank = Rank.NONE;

        //when
        boolean result = rank.win(2, false);

        //then
        assertThat(result).isTrue();
    }

    @DisplayName("맞은 개수가 1개이고 보너스 번호가 맞은 경우 등수가 없다.")
    @Test
    void noneCase3() {
        //given
        Rank rank = Rank.NONE;

        //when
        boolean result = rank.win(1, true);

        //then
        assertThat(result).isTrue();
    }

    @DisplayName("맞은 개수가 1개이고 보너스 번호가 틀린 경우 등수가 없다.")
    @Test
    void noneCase4() {
        //given
        Rank rank = Rank.NONE;

        //when
        boolean result = rank.win(1, false);

        //then
        assertThat(result).isTrue();
    }

    @DisplayName("맞은 개수가 0개이고 보너스 번호가 맞은 경우 등수가 없다.")
    @Test
    void noneCase5() {
        //given
        Rank rank = Rank.NONE;

        //when
        boolean result = rank.win(0, true);

        //then
        assertThat(result).isTrue();
    }

    @DisplayName("맞은 개수가 0개이고 보너스 번호가 틀린 경우 등수가 없다.")
    @Test
    void noneCase6() {
        //given
        Rank rank = Rank.NONE;

        //when
        boolean result = rank.win(0, false);

        //then
        assertThat(result).isTrue();
    }

}