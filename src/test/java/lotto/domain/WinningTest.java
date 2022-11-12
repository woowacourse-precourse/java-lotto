package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class WinningTest {

    @DisplayName("등수를 올바르게 계산하는지")
    @Test
    void calMyScore() {
        Lotto lotto = mock(Lotto.class);
        WinningLotto winningLotto = mock(WinningLotto.class);

        when(lotto.getNumbers())
                .thenReturn(Stream.of(1, 2, 3, 4, 5, 6).collect(Collectors.toList()));
        when(winningLotto.getNumbers())
                .thenReturn(Stream.of(1, 2, 3, 4, 5, 6).collect(Collectors.toList()));
        when(winningLotto.getBonusNumber())
                .thenReturn(7);

        Winning w = new Winning(lotto, winningLotto);
        assertThat(w.calMyScore()).isEqualTo(WinningTable.FIRST);
    }


}