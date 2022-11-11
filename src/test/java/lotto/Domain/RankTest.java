package lotto.Domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;


class RankTest {
    Rank rank = new Rank();

    @Nested
    @DisplayName("setRank 테스트")
    class TestSetRank {

    }

    @Nested
    @DisplayName("countWinningNumber 메소드 테스트")
    class TestCountWinningNumber {

        @Test
        @DisplayName("6개가 일치할 경우")
        void case1() {
            List<Integer> lotto = List.of(1, 2, 3, 4, 5, 6);
            List<Integer> playerLotto = List.of(1, 2, 3, 4, 5, 6);
            int result = rank.countWinningNumber(lotto, playerLotto);
            assertThat(result).isEqualTo(6);
        }

        @Test
        @DisplayName("5개가 일치할 경우")
        void case2() {
            List<Integer> lotto = List.of(1, 2, 3, 4, 5, 6);
            List<Integer> playerLotto = List.of(1, 2, 3, 4, 5, 45);
            int result = rank.countWinningNumber(lotto, playerLotto);
            assertThat(result).isEqualTo(5);
        }

        @Test
        @DisplayName("4개가 일치할 경우")
        void case3() {
            List<Integer> lotto = List.of(1, 2, 3, 4, 5, 6);
            List<Integer> playerLotto = List.of(1, 2, 3, 4, 15, 16);
            int result = rank.countWinningNumber(lotto, playerLotto);
            assertThat(result).isEqualTo(4);
        }

        @Test
        @DisplayName("3개가 일치할 경우")
        void case4() {
            List<Integer> lotto = List.of(1, 2, 3, 4, 5, 6);
            List<Integer> playerLotto = List.of(1, 2, 3, 14, 15, 16);
            int result = rank.countWinningNumber(lotto, playerLotto);
            assertThat(result).isEqualTo(3);
        }

        @Test
        @DisplayName("2개가 일치할 경우")
        void case5() {
            List<Integer> lotto = List.of(1, 2, 13, 41, 25, 36);
            List<Integer> playerLotto = List.of(1, 2, 3, 4, 5, 6);
            int result = rank.countWinningNumber(lotto, playerLotto);
            assertThat(result).isEqualTo(2);
        }

        @Test
        @DisplayName("1개가 일치할 경우")
        void case6() {
            List<Integer> lotto = List.of(1, 2, 3, 4, 5, 6);
            List<Integer> playerLotto = List.of(1, 12, 13, 14, 15, 16);
            int result = rank.countWinningNumber(lotto, playerLotto);
            assertThat(result).isEqualTo(1);
        }

        @Test
        @DisplayName("일치하지 않을 경우")
        void case7() {
            List<Integer> lotto = List.of(1, 2, 3, 4, 5, 6);
            List<Integer> playerLotto = List.of(11, 12, 13, 14, 15, 16);
            int result = rank.countWinningNumber(lotto, playerLotto);
            assertThat(result).isEqualTo(0);
        }
    }
}