package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class WinningTest {

    @DisplayName("등수를 올바르게 계산하는지")
    @Nested
    class CalMyScore {
        Lotto lotto;
        WinningLotto winningLotto;
        Winning winning;
        @BeforeEach
        void setUp() {
            lotto = mock(Lotto.class);
            winningLotto = mock(WinningLotto.class);
            winning = new Winning();
        }

        @DisplayName("맞춘 번호 : 6개, 1등 당첨")
        @Test
        void case1() {
            when(lotto.getNumbers())
                    .thenReturn(Stream.of(1, 2, 3, 4, 5, 6).collect(Collectors.toList()));
            when(winningLotto.getNumbers())
                    .thenReturn(Stream.of(1, 2, 3, 4, 5, 6).collect(Collectors.toList()));
            when(winningLotto.getBonusNumber())
                    .thenReturn(7);

            assertThat(winning.calMyScore(lotto, winningLotto)).isEqualTo(WinningTable.FIRST);
        }

        @DisplayName("맞춘 번호 : 5개, 보너스 2등 당첨")
        @Test
        void case2() {
            when(lotto.getNumbers())
                    .thenReturn(Stream.of(1, 2, 3, 4, 5, 7).collect(Collectors.toList()));
            when(winningLotto.getNumbers())
                    .thenReturn(Stream.of(1, 2, 3, 4, 5, 6).collect(Collectors.toList()));
            when(winningLotto.getBonusNumber())
                    .thenReturn(7);

            assertThat(winning.calMyScore(lotto, winningLotto)).isEqualTo(WinningTable.SECOND);
        }

        @DisplayName("맞춘 번호 : 5개, 3등 당첨")
        @Test
        void case3() {
            when(lotto.getNumbers())
                    .thenReturn(Stream.of(1, 2, 3, 4, 5, 8).collect(Collectors.toList()));
            when(winningLotto.getNumbers())
                    .thenReturn(Stream.of(1, 2, 3, 4, 5, 6).collect(Collectors.toList()));
            when(winningLotto.getBonusNumber())
                    .thenReturn(7);

            assertThat(winning.calMyScore(lotto, winningLotto)).isEqualTo(WinningTable.THIRD);
        }

        @DisplayName("맞춘 번호 : 4개, 4등 당첨")
        @Test
        void case4() {
            when(lotto.getNumbers())
                    .thenReturn(Stream.of(1, 2, 3, 4, 8, 10).collect(Collectors.toList()));
            when(winningLotto.getNumbers())
                    .thenReturn(Stream.of(1, 2, 3, 4, 5, 6).collect(Collectors.toList()));
            when(winningLotto.getBonusNumber())
                    .thenReturn(7);

            assertThat(winning.calMyScore(lotto, winningLotto)).isEqualTo(WinningTable.FORTH);
        }

        @DisplayName("맞춘 번호 : 3개, 5등 당첨")
        @Test
        void case5() {
            when(lotto.getNumbers())
                    .thenReturn(Stream.of(1, 2, 3, 8, 9, 10).collect(Collectors.toList()));
            when(winningLotto.getNumbers())
                    .thenReturn(Stream.of(1, 2, 3, 4, 5, 6).collect(Collectors.toList()));
            when(winningLotto.getBonusNumber())
                    .thenReturn(7);

            assertThat(winning.calMyScore(lotto, winningLotto)).isEqualTo(WinningTable.FIFTH);
        }

        @DisplayName("맞춘 번호 : 2개, 꽝")
        @Test
        void case6() {
            when(lotto.getNumbers())
                    .thenReturn(Stream.of(1, 2, 8, 9, 10, 11).collect(Collectors.toList()));
            when(winningLotto.getNumbers())
                    .thenReturn(Stream.of(1, 2, 3, 4, 5, 6).collect(Collectors.toList()));
            when(winningLotto.getBonusNumber())
                    .thenReturn(7);

            assertThat(winning.calMyScore(lotto, winningLotto)).isEqualTo(WinningTable.LOSE);
        }

        @DisplayName("맞춘 번호 : 1개, 꽝")
        @Test
        void case7() {
            when(lotto.getNumbers())
                    .thenReturn(Stream.of(1, 8, 9, 10, 11, 12).collect(Collectors.toList()));
            when(winningLotto.getNumbers())
                    .thenReturn(Stream.of(1, 2, 3, 4, 5, 6).collect(Collectors.toList()));
            when(winningLotto.getBonusNumber())
                    .thenReturn(7);

            assertThat(winning.calMyScore(lotto, winningLotto)).isEqualTo(WinningTable.LOSE);
        }

        @DisplayName("맞춘 번호 : 0개, 꽝")
        @Test
        void case8() {
            when(lotto.getNumbers())
                    .thenReturn(Stream.of(13, 8, 9, 10, 11, 12).collect(Collectors.toList()));
            when(winningLotto.getNumbers())
                    .thenReturn(Stream.of(1, 2, 3, 4, 5, 6).collect(Collectors.toList()));
            when(winningLotto.getBonusNumber())
                    .thenReturn(7);

            assertThat(winning.calMyScore(lotto, winningLotto)).isEqualTo(WinningTable.LOSE);
        }
    }


}