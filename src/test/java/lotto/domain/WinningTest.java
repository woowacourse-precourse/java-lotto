package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class WinningTest {

    @DisplayName("등수를 올바르게 계산하는지")
    @Nested
    class CalMyScore {
        Lotto lotto;
        List<Integer> winningNumbers;
        int bonus;
        Winning winning;

        @BeforeEach
        void setUp() {
            lotto = mock(Lotto.class);
        }

        @DisplayName("맞춘 번호 : 6개, 1등 당첨")
        @Test
        void case1() {
            winningNumbers = List.of(1,2,3,4,5,6);
            bonus = 7;
            when(lotto.matchCount(winningNumbers))
                    .thenReturn(6);
            winning = new Winning(winningNumbers, bonus);
            assertThat(winning.calMyScore(lotto)).isEqualTo(WinningTable.FIRST);
        }

        @DisplayName("맞춘 번호 : 5개, 보너스 2등 당첨")
        @Test
        void case2() {
            winningNumbers = List.of(1,2,3,4,5,6);
            bonus = 7;
            when(lotto.matchCount(winningNumbers))
                    .thenReturn(5);
            when(lotto.containsBonus(bonus))
                    .thenReturn(true);
            winning = new Winning(winningNumbers, bonus);
            assertThat(winning.calMyScore(lotto)).isEqualTo(WinningTable.SECOND);
        }

        @DisplayName("맞춘 번호 : 5개, 3등 당첨")
        @Test
        void case3() {
            winningNumbers = List.of(1,2,3,4,5,6);
            bonus = 7;
            when(lotto.matchCount(winningNumbers))
                    .thenReturn(5);
            winning = new Winning(winningNumbers, bonus);
            assertThat(winning.calMyScore(lotto)).isEqualTo(WinningTable.THIRD);
        }

        @DisplayName("맞춘 번호 : 4개, 4등 당첨")
        @Test
        void case4() {
            winningNumbers = List.of(1,2,3,4,5,6);
            bonus = 7;
            when(lotto.matchCount(winningNumbers))
                    .thenReturn(4);
            winning = new Winning(winningNumbers, bonus);
            assertThat(winning.calMyScore(lotto)).isEqualTo(WinningTable.FORTH);
        }

        @DisplayName("맞춘 번호 : 3개, 5등 당첨")
        @Test
        void case5() {
            winningNumbers = List.of(1,2,3,4,5,6);
            bonus = 7;
            when(lotto.matchCount(winningNumbers))
                    .thenReturn(3);
            winning = new Winning(winningNumbers, bonus);
            assertThat(winning.calMyScore(lotto)).isEqualTo(WinningTable.FIFTH);
        }

        @DisplayName("맞춘 번호 : 2개, 꽝")
        @Test
        void case6() {
            winningNumbers = List.of(1,2,3,4,5,6);
            bonus = 7;
            when(lotto.matchCount(winningNumbers))
                    .thenReturn(2);
            winning = new Winning(winningNumbers, bonus);
            assertThat(winning.calMyScore(lotto)).isEqualTo(WinningTable.LOSE);
        }

        @DisplayName("맞춘 번호 : 1개, 꽝")
        @Test
        void case7() {
            winningNumbers = List.of(1,2,3,4,5,6);
            bonus = 7;
            when(lotto.matchCount(winningNumbers))
                    .thenReturn(1);
            winning = new Winning(winningNumbers, bonus);
            assertThat(winning.calMyScore(lotto)).isEqualTo(WinningTable.LOSE);
        }

        @DisplayName("맞춘 번호 : 0개, 꽝")
        @Test
        void case8() {
            winningNumbers = List.of(1,2,3,4,5,6);
            bonus = 7;
            when(lotto.matchCount(winningNumbers))
                    .thenReturn(0);
            winning = new Winning(winningNumbers, bonus);
            assertThat(winning.calMyScore(lotto)).isEqualTo(WinningTable.LOSE);
        }
    }


}