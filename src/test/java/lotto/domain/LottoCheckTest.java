package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoCheckTest {
    private LottoCheck check;

    @BeforeEach
    void beforeEach() {
        check = new LottoCheck();
    }

    @DisplayName("로또 번호와 당첨 번호의 일치 개수 테스트")
    @Test
    void checkWinningTest() {
        // given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> sixMatch = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> fiveMatch = List.of(1, 2, 3, 4, 5, 30);
        List<Integer> fourMatch = List.of(1, 2, 3, 4, 30, 31);
        List<Integer> threeMatch = List.of(1, 2, 3, 40, 41, 42);

        // when, then
        assertThat(check.checkWinning(winningNumbers, sixMatch)).isEqualTo(6);
        assertThat(check.checkWinning(winningNumbers, fiveMatch)).isEqualTo(5);
        assertThat(check.checkWinning(winningNumbers, fourMatch)).isEqualTo(4);
        assertThat(check.checkWinning(winningNumbers, threeMatch)).isEqualTo(3);
    }

    @DisplayName("로또 번호에 보너스 번호 존재여부 테스트")
    @Test
    void checkBonusTest() {
        // given
        List<Integer> trueNumbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> falseNumbers = List.of(11, 22, 33, 44, 45, 16);
        int bonus = 6;

        // when, then
        assertTrue(check.checkBonus(bonus, trueNumbers));
        assertFalse(check.checkBonus(bonus, falseNumbers));
    }

    @DisplayName("등수 확인 테스트")
    @Test
    void checkRankingTest() {
        // given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> first = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> second = List.of(1, 2, 3, 4, 5, 7);
        List<Integer> third = List.of(1, 2, 3, 4, 5, 30);
        List<Integer> fourth = List.of(1, 2, 3, 4, 30, 31);
        List<Integer> fifth = List.of(1, 2, 3, 40, 41, 42);
        int bonus = 7;

        // when, then
        assertThat(check.checkRanking(winningNumbers, first, bonus)).isEqualTo("FIRST");
        assertThat(check.checkRanking(winningNumbers, second, bonus)).isEqualTo("SECOND");
        assertThat(check.checkRanking(winningNumbers, third, bonus)).isEqualTo("THIRD");
        assertThat(check.checkRanking(winningNumbers, fourth, bonus)).isEqualTo("FOURTH");
        assertThat(check.checkRanking(winningNumbers, fifth, bonus)).isEqualTo("FIFTH");
    }
}